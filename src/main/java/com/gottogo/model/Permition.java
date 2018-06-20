package com.gottogo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Permition implements GrantedAuthority {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@ManyToMany(mappedBy = "permitions")
	private List<UserSys> userSys;
	

	public List<UserSys> getUsers() {
		return userSys;
	}

	public void setUsers(List<UserSys> userSys) {
		this.userSys = userSys;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
