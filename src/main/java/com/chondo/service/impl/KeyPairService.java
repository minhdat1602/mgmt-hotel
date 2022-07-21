package com.chondo.service.impl;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chondo.dto.KeyPairDTO;
import com.chondo.entity.KeyPairEntity;
import com.chondo.repository.KeyPairRepository;
import com.chondo.service.IKeyPairService;

@Service
public class KeyPairService implements IKeyPairService {

	@Autowired
	private KeyPairRepository keyPairRepository;

	@Override
	public List<KeyPairDTO> getAll() {
		ModelMapper mapper = new ModelMapper();
		return keyPairRepository.findAll().stream().map((key -> mapper.map(key, KeyPairDTO.class)))
				.collect(Collectors.toList());
	}

	@Override
	public KeyPairDTO save() {
		try {
			ModelMapper mapper = new ModelMapper();

			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			SecureRandom srandom = SecureRandom.getInstanceStrong();
			keyPairGenerator.initialize(2048, srandom);

			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			PrivateKey privateKey = keyPair.getPrivate();
			PublicKey publicKey = keyPair.getPublic();
			
			KeyPairEntity entity = new KeyPairEntity();
			entity.setPrivateKey(new String(Base64.getEncoder().encode(privateKey.getEncoded())));
			entity.setPublicKey(new String(Base64.getEncoder().encode(publicKey.getEncoded())));
			
			entity = keyPairRepository.save(entity);
			
			return mapper.map(entity, KeyPairDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		keyPairRepository.delete(id);
	}

}
