package com.chondo.service;

import java.util.List;

import com.chondo.dto.RoomTypeDTO;

public interface RoomsService {
	List<RoomTypeDTO> findAll();
	List<RoomTypeDTO> findByKey(String keyword);
}
