package com.teravin.task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
public class UserModel {
	
	@Id
	@Column(name="nama_user")
	private String nama_user;
	
	@Column(name="no_hp")
	private String no_hp;
	
	@Column(name="email")
	private String email;
	
	@Column(name="alamat1")
	private String alamat1;
	
	@Column(name="alamat2")
	private String alamat2;
	
	@Column(name="alamat3")
	private String alamat3;


	public String getNama_user() {
		return nama_user;
	}

	public void setNama_user(String nama_user) {
		this.nama_user = nama_user;
	}

	public String getNo_hp() {
		return no_hp;
	}

	public void setNo_hp(String no_hp) {
		this.no_hp = no_hp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlamat1() {
		return alamat1;
	}

	public void setAlamat1(String alamat1) {
		this.alamat1 = alamat1;
	}

	public String getAlamat2() {
		return alamat2;
	}

	public void setAlamat2(String alamat2) {
		this.alamat2 = alamat2;
	}

	public String getAlamat3() {
		return alamat3;
	}

	public void setAlamat3(String alamat3) {
		this.alamat3 = alamat3;
	}
	
}
