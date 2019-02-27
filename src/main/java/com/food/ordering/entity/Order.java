package com.food.ordering.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int order_id;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="food_id")
	private Food food_id;
	@ManyToOne
	@JoinColumn(name= "user_id")
	private User user_id;
	private String address;
	private Date date_create;
	@ManyToOne
	@JoinColumn(name= "status_id")
	private Status status_id;
	public Order() {
		super();
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Food getFood_id() {
		return food_id;
	}
	public void setFood_id(Food food_id) {
		this.food_id = food_id;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate_create() {
		return date_create;
	}
	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}
	public Status getStatus_id() {
		return status_id;
	}
	public void setStatus_id(Status status_id) {
		this.status_id = status_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
