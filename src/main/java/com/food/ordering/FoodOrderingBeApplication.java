package com.food.ordering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.food.ordering.repository.UserRepository;

@SpringBootApplication
public class FoodOrderingBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderingBeApplication.class, args);
	}

}
