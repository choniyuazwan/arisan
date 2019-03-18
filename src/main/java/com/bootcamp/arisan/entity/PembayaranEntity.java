package com.bootcamp.arisan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_pembayaran")
public class PembayaranEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_anggota")
	private int id_anggota;
	
	@Column(name="id_bulan")
	private int id_bulan;
	
	@Column(name="jumlah_iuran")
	private int jumlah_iuran;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_anggota() {
		return id_anggota;
	}

	public void setId_anggota(int id_anggota) {
		this.id_anggota = id_anggota;
	}

	public int getId_bulan() {
		return id_bulan;
	}

	public void setId_bulan(int id_bulan) {
		this.id_bulan = id_bulan;
	}

	public int getJumlah_iuran() {
		return jumlah_iuran;
	}

	public void setJumlah_iuran(int jumlah_iuran) {
		this.jumlah_iuran = jumlah_iuran;
	}
}
