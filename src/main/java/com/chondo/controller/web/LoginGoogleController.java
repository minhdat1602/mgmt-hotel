package com.chondo.controller.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.chondo.dto.MyUser;
import com.chondo.entity.UserEntity;
import com.chondo.google.GooglePojo;
import com.chondo.google.GoogleUtils;
import com.chondo.repository.UserGroupRepository;
import com.chondo.repository.UserRepository;
import com.chondo.service.impl.CustomUserDetailsService;
import com.chondo.service.impl.UserService;

@Controller
public class LoginGoogleController {

	@Autowired
	private GoogleUtils googleUtils;
	
	@Autowired
	private CustomUserDetailsService userService;
	
	@Autowired
	private UserGroupRepository userGroupRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/login-google")
	public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
		String code = request.getParameter("code");

		if (code == null || code.isEmpty()) {
			return "redirect:/dang-nhap?incorrectAccount";
		}
		String accessToken = googleUtils.getToken(code);

		GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
		
		//check exists user
		MyUser userDetail;
		try {
			userDetail = (MyUser) userService.loadUserByUsername(googlePojo.getEmail());
		}catch(Exception e) {
			System.out.println("TEST");
			userDetail = null;
		}
		
		if(userDetail == null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setUsername(googlePojo.getEmail());
			userEntity.setEmail(googlePojo.getEmail());
			userEntity.setPassword("");
			userEntity.setFullname(googlePojo.getEmail());
			userEntity.setGroup(userGroupRepository.findOneById(1l));
			userEntity = userRepository.save(userEntity);
			
//			userDetail = userService.loadUserByUsername(googlePojo.getEmail());
			userDetail = googleUtils.buildUser(googlePojo);
			userDetail.setFullname(googlePojo.getEmail());
		}
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
				userDetail.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/trang-chu";
	}

}
