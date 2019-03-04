package com.food.ordering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.ordering.entity.Food;
import com.food.ordering.service.ItemService;

@RestController
@RequestMapping("items")
public class FoodController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/unauth")
	public ResponseEntity<Food> getAll(){
		return new ResponseEntity(itemService.getAllFood(),HttpStatus.OK);
	}
	
	@GetMapping("/unauth/{id}")
	public ResponseEntity<Food> getItemById(@PathVariable("id")Integer id){
		if(itemService.findFoodById(id)==null) {
			return new ResponseEntity("Item not found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(itemService.findFoodById(id),HttpStatus.OK);
	}
	
	@PostMapping("auth/addItem")
	public ResponseEntity<Food> addItem(@RequestBody Food food){
		return new ResponseEntity(itemService.createFood(food),HttpStatus.OK);
	}
	
	@PutMapping("auth/update")
	public ResponseEntity<Food> update(@RequestBody Food food){
		if(itemService.findFoodById(food.getFood_id())==null) {
			return new ResponseEntity("Item not found",HttpStatus.NOT_FOUND);
		}
		else return new ResponseEntity(itemService.createFood(food),HttpStatus.OK);
	}

	@DeleteMapping("auth/{id}")
	public ResponseEntity<Food> delete(@PathVariable("id")Integer id){
		if(itemService.deleteFood(id)) {
			return new ResponseEntity("Delete "+id+" success",HttpStatus.OK);
		}
		else
			return new ResponseEntity("Delete "+id+" false",HttpStatus.BAD_REQUEST);
	}
}
