package com.food.ordering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.ordering.entity.Food;
import com.food.ordering.entity.Profile;
import com.food.ordering.entity.User;
import com.food.ordering.service.ProfileService;
import com.food.ordering.service.UserService;

@RestController
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/profiles")
	public ResponseEntity<Profile> getAll(){
		return new ResponseEntity(profileService.getAllProfile(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}/profile")
	public ResponseEntity<Food> getItemById(@PathVariable("id")Integer id){
		User user = userService.findUserById(id);
		if(profileService.findProfileByUserId(user)==null) {
			return new ResponseEntity("Item not found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(profileService.findProfileByUserId(user),HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}/profile/update")
	public ResponseEntity<Profile> update(@PathVariable("id")Integer id,@RequestBody Profile profile){
		User user = userService.findUserById(id);
		return new ResponseEntity(profileService.createProfile(profile),HttpStatus.OK);
	}

}
