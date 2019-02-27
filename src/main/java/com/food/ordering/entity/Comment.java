package com.food.ordering.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int comment_id;
	
	@ManyToOne
	@JoinColumn(name="food_id")
	private Food food_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user_id;
	
	private String content;
	
	private Date create_date;

	public Comment() {
		super();
	}

	public Comment(int comment_id, Food food_id, User user_id, String content, Date create_date) {
		super();
		this.comment_id = comment_id;
		this.food_id = food_id;
		this.user_id = user_id;
		this.content = content;
		this.create_date = create_date;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	
	
}
