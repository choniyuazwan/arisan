package com.bootcamp.arisan.controller;

import java.util.List;
import java.util.Optional;

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
import com.bootcamp.arisan.entity.IuranEntity;
import com.bootcamp.arisan.entity.PembayaranEntity;
import com.bootcamp.arisan.repository.AnggotaRepository;
import com.bootcamp.arisan.repository.IuranRepository;
import com.bootcamp.arisan.repository.PembayaranRepository;

@EnableWebMvc
@RestController
@RequestMapping(path="/pembayaran")
public class PembayaranController {
	@Autowired
	PembayaranRepository pembayaranRepository;
	
	@Autowired
	AnggotaRepository  anggotaRepository;
	
	@Autowired
	IuranRepository iuranRepository;
	
	@GetMapping(path="")
	public @ResponseBody List<PembayaranEntity> get() {
		List<PembayaranEntity> pembayaranEntity = pembayaranRepository.findAll();
		return pembayaranEntity;
	}
	
	@PostMapping(path="")
	public PembayaranEntity add(@Valid @RequestBody PembayaranEntity pembayaranEntity) {
		Optional<AnggotaEntity> anggotaEntity =  anggotaRepository.findById(pembayaranEntity.getId_anggota());		
		int totalBayar = anggotaEntity.get().getTotal_bayar();
		anggotaEntity.get().setTotal_bayar(totalBayar+pembayaranEntity.getJumlah_iuran());
		anggotaRepository.save(anggotaEntity.get());
		
		Optional<IuranEntity> iuranEntity =  iuranRepository.findById(pembayaranEntity.getId_bulan());		
		int jumlahIuran = iuranEntity.get().getTotalIuran();
		iuranEntity.get().setTotalIuran(jumlahIuran+pembayaranEntity.getJumlah_iuran());
		iuranRepository.save(iuranEntity.get());

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
