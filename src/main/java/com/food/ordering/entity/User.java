package com.food.ordering.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	private String username;
	private String password_encode;
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role_id;
	private boolean alive;
	
	
	
	public User(String username, String password_encode, boolean alive) {
		super();
		this.username = username;
		this.password_encode = password_encode;
		this.alive = alive;
	}

	public User(String username, String password_encode, Role role_id, boolean alive) {
		super();
		this.username = username;
		this.password_encode = password_encode;
		this.role_id = role_id;
		this.alive = alive;
	}

	public User(int user_id, String username, String password_encode, Role role_id, boolean alive) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password_encode = password_encode;
		this.role_id = role_id;
		this.alive = alive;
	}

	public User() {
		super();
	}

	public int getId() {
		return user_id;
	}

	public void setId(int id) {
		this.user_id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword_encode() {
		return password_encode;
	}

	public void setPassword_encode(String password_encode) {
		this.password_encode = password_encode;
	}

	public Role getRole() {
		return role_id;
	}

	public void setRole(Role role) {
		this.role_id = role;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
