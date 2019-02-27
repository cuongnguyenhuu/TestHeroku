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
@Table(name = "foods")
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int food_id;
	private String food_name;
	private Float price;
	private String title;
	private String description;
	private String picture;
	private Date date_create;
	private int views;
	@ManyToOne
	@JoinColumn(name= "user_id")
	private User user_id;
	@ManyToOne
	@JoinColumn(name= "category_id")
	private Category category_id;
	public Food() {
		super();
	}
	
	public Food(String food_name, Float price, String title, String description, String picture, Date date_create,
			int views, User user_id, Category category_id) {
		this.food_name = food_name;
		this.price = price;
		this.title = title;
		this.description = description;
		this.picture = picture;
		this.date_create = date_create;
		this.views = views;
		this.user_id = user_id;
		this.category_id = category_id;
	}

	public Food(int food_id, String food_name, Float price, String title, String description, String picture,
			Date date_create, int views, User user_id, Category category_id) {
		super();
		this.food_id = food_id;
		this.food_name = food_name;
		this.price = price;
		this.title = title;
		this.description = description;
		this.picture = picture;
		this.date_create = date_create;
		this.views = views;
		this.user_id = user_id;
		this.category_id = category_id;
	}

	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getDate_create() {
		return date_create;
	}
	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	public Category getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Category category_id) {
		this.category_id = category_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
