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

import com.bootcamp.arisan.entity.PembayaranEntity;
import com.bootcamp.arisan.repository.PembayaranRepository;

@EnableWebMvc
@RestController
@RequestMapping(path="/pembayaran")
public class PembayaranController {
	@Autowired
	PembayaranRepository pembayaranRepository;
	
	@GetMapping(path="")
	public @ResponseBody List<PembayaranEntity> get() {
		List<PembayaranEntity> pembayaranEntity = pembayaranRepository.findAll();
		return pembayaranEntity;
	}
	
	@PostMapping(path="")
	public PembayaranEntity add(@Valid @RequestBody PembayaranEntity pembayaranEntity) {
		return pembayaranRepository.save(pembayaranEntity);
	}
	
	@PutMapping("/{id}")
	PembayaranEntity update(@RequestBody PembayaranEntity newPembayaranEntity, @PathVariable Integer id) {

		return pembayaranRepository.findById(id)
			.map(pembayaranEntity-> {
				pembayaranEntity.setId_anggota(newPembayaranEntity.getId_anggota());
				pembayaranEntity.setId_bulan(newPembayaranEntity.getId_bulan());
				pembayaranEntity.setJumlah_iuran(newPembayaranEntity.getJumlah_iuran());
				return pembayaranRepository.save(pembayaranEntity);
			})
			.orElseGet(() -> {
				newPembayaranEntity.setId(id);
				return pembayaranRepository.save(newPembayaranEntity);
			});
	}
}
