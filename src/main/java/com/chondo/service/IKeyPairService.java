package com.chondo.service;

import java.util.List;

import com.chondo.dto.KeyPairDTO;

public interface IKeyPairService {

	List<KeyPairDTO> getAll();

	KeyPairDTO save();

	void delete(Long id);

}
