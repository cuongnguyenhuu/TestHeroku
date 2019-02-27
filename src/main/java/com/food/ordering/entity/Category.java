package com.food.ordering.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories_food")
public class Category implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int category_id;
	private String category_name;
	public Category() {
		super();
	}
	
	public Category(String category_name) {
		super();
		this.category_name = category_name;
	}

	public Category(int category_id, String category_name) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
	}

	public int getCategories_id() {
		return category_id;
	}
	public void setCategories_id(int categories_id) {
		this.category_id = categories_id;
	}
	public String getCategories_name() {
		return category_name;
	}
	public void setCategories_name(String categories_name) {
		this.category_name = categories_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
