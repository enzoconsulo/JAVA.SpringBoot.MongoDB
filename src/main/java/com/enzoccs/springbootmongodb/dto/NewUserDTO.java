package com.enzoccs.springbootmongodb.dto;

import java.io.Serializable;

import com.enzoccs.springbootmongodb.domain.User;

public class NewUserDTO implements Serializable{
private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private String password;
	
	public NewUserDTO() {
	}
	
	public NewUserDTO(User user) {
		id = user.getId();			// 	DTO 
		name = user.getName();		//with password(to use on fromDTO) 
		email = user.getEmail();
		password = user.getPassword();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
