package com.food.ordering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.ordering.entity.User;
import com.food.ordering.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	public User findUserById(int userId) {
		return userRepository.getOne(userId);
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public boolean deleteUser(int userId)  {
		User user = userRepository.getOne(userId);
		if (user!=null) {
			userRepository.deleteById(userId);
			return true;
		}
		else
			return false;
	}
}
