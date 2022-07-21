package com.chondo.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chondo.dto.RoomTypeDTO;
import com.chondo.service.RoomsService;

@Controller
public class RoomsController {
	
	@Autowired
	private RoomsService roomsService;
	
	@GetMapping("/rooms")
	public ModelAndView getRooms() {
		ModelAndView mav = new ModelAndView("web/rooms");
		
		List<RoomTypeDTO> result = roomsService.findAll();
		mav.addObject("rooms", result);
		
		return mav;
	}
	
	@GetMapping("/room")
	public ModelAndView findRooms(@RequestParam String keyword) {
		ModelAndView mav = new ModelAndView("web/rooms");
		
		List<RoomTypeDTO> result = roomsService.findByKey(keyword);
		mav.addObject("rooms", result);
		
		return mav;
	}
}
