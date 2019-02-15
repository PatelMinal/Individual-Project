package com.springboot.individualproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "login")
public class myIndivdualProjectLoginModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long login_id;
	
	@NotBlank
	@Column(name = "password")
	private String password;
	
	@Column(name = "login")
	private String login;
	

	

public  myIndivdualProjectLoginModel(String password, String login) {
		this.login_id = login_id;
		this.password = password;
		this.login = login;
	
		
	}
	
	public  myIndivdualProjectLoginModel() {
	}
	
	public Long getLogin_id() {
		return login_id;
	}

	public void setLogin_id(Long login_id) {
		this.login_id = login_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}