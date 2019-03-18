package com.bootcamp.arisan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bootcamp.arisan.entity.AnggotaEntity;
import com.bootcamp.arisan.repository.AnggotaRepository;

@EnableWebMvc
@RestController
@RequestMapping(path="/anggota")
public class AnggotaController {
	@Autowired
	AnggotaRepository anggotaRepository;
	
	@GetMapping(path="")
	public @ResponseBody List<AnggotaEntity> get() {
		List<AnggotaEntity> anggotaEntity = anggotaRepository.findAll();
		return anggotaEntity;
	}
	
	@PostMapping(path="")
	public AnggotaEntity add(@Valid @RequestBody AnggotaEntity anggotaEntity) {
		return anggotaRepository.save(anggotaEntity);
	}
	
	@PutMapping("/{id}")
	AnggotaEntity update(@RequestBody AnggotaEntity newAnggotaEntity, @PathVariable Integer id) {

		return anggotaRepository.findById(id)
			.map(anggotaEntity-> {
				anggotaEntity.setNama(newAnggotaEntity.getNama());
				anggotaEntity.setKelas(newAnggotaEntity.getKelas());
				anggotaEntity.setTotal_bayar(newAnggotaEntity.getTotal_bayar());
				return anggotaRepository.save(anggotaEntity);
			})
			.orElseGet(() -> {
				newAnggotaEntity.setId(id);
				return anggotaRepository.save(newAnggotaEntity);
			});
	}
}
