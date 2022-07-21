package com.chondo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chondo.dto.KeyPairDTO;
import com.chondo.service.IKeyPairService;

@Controller
public class KeyController {

	@Autowired
	private IKeyPairService keyPairService;

	@GetMapping("/quan-tri/khoa")
	public ModelAndView getKeyPair() {
		ModelAndView mav = new ModelAndView("admin/key/list-key");

		List<KeyPairDTO> keyPairs = keyPairService.getAll();
		mav.addObject("keyPairs", keyPairs);

		return mav;
	}

	@GetMapping("/quan-tri/khoa/xoa")
	public ModelAndView deleteKeyPair(@RequestParam(value = "id", required = true) Long id) {
		ModelAndView mav = new ModelAndView("admin/key/list-key");

		keyPairService.delete(id);

		List<KeyPairDTO> keyPairs = keyPairService.getAll();
		mav.addObject("keyPairs", keyPairs);

		return mav;
	}
	
	
	@GetMapping("/quan-tri/khoa/phat-sinh")
	public ModelAndView addKeyPair() {
		ModelAndView mav = new ModelAndView("admin/key/list-key");
		
		keyPairService.save();

		List<KeyPairDTO> keyPairs = keyPairService.getAll();
		mav.addObject("keyPairs", keyPairs);	
		

		return mav;
	}
}
