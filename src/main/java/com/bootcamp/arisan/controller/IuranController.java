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

import com.bootcamp.arisan.entity.IuranEntity;
import com.bootcamp.arisan.repository.IuranRepository;

@EnableWebMvc
@RestController
@RequestMapping(path="/iuran")
public class IuranController {
	@Autowired
	IuranRepository iuranRepository;
	
	@GetMapping(path="")
	public @ResponseBody List<IuranEntity> get() {
		List<IuranEntity> iuranEntity = iuranRepository.findAll();
		return iuranEntity;
	}
	
	@PostMapping(path="")
	public IuranEntity add(@Valid @RequestBody IuranEntity iuranEntity) {
		return iuranRepository.save(iuranEntity);
	}
	
	@PutMapping("/{id}")
	IuranEntity update(@RequestBody IuranEntity newIuranEntity, @PathVariable Integer id) {
		return iuranRepository.findById(id)
				.map(iuranEntity-> {
					iuranEntity.setBulan(newIuranEntity.getBulan());
					iuranEntity.setTotalIuran(newIuranEntity.getTotalIuran());;
					return iuranRepository.save(iuranEntity);
				})
				.orElseGet(() -> {
					newIuranEntity.setId(id);
					return iuranRepository.save(newIuranEntity);
				});
	}
}
