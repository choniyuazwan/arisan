package com.bootcamp.arisan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_anggota")
public class AnggotaEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nama")
	private String nama;
	
	@Column(name="kelas")
	private String kelas;
	
	@Column(name="total_bayar")
	private String total_bayar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	public String getTotal_bayar() {
		return total_bayar;
	}

	public void setTotal_bayar(String total_bayar) {
		this.total_bayar = total_bayar;
	}
}
