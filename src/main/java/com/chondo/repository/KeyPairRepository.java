package com.chondo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chondo.entity.KeyPairEntity;

@Repository
public interface KeyPairRepository extends JpaRepository<KeyPairEntity, Long> {

	Optional<KeyPairEntity> findByPublicKey(String publicKey);
	
	Optional<KeyPairEntity> findByPrivateKey(String privateKey);
	
	Optional<KeyPairEntity> findByActive(Integer active);
}
