package com.bootcamp.arisan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.arisan.entity.AnggotaEntity;

@Repository
public interface AnggotaRepository extends JpaRepository<AnggotaEntity, Integer> {

}
