package com.sanok.forum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {

	
	@Id
	@Column(name = "idAdmin")
	@GeneratedValue
	private int idAdmin;

	
	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	@Column(name = "adminName")
	private String adminName;
	
	
	@Column(name = "adminPassword")
	private String adminPassword;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
}
