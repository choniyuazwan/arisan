package com.bootcamp.arisan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_iuran")
public class IuranEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="bulan")
	private String bulan;
	
	@Column(name="total_iuran")
	private int totalIuran;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBulan() {
		return bulan;
	}

	public void setBulan(String bulan) {
		this.bulan = bulan;
	}

	public int getTotalIuran() {
		return totalIuran;
	}

	public void setTotalIuran(int totalIuran) {
		this.totalIuran = totalIuran;
	}
}
