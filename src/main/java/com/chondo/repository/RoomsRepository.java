package com.chondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chondo.entity.RoomTypeEntity;

@Repository
public interface RoomsRepository extends JpaRepository<RoomTypeEntity, Long>{
	List<RoomTypeEntity> findByNameLike(String keyword);
}
