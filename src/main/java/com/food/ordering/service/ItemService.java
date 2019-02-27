package com.food.ordering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.ordering.entity.Food;
import com.food.ordering.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public List<Food> getAllFood(){
		return itemRepository.findAll();
	}
	
	public Food findFoodById(int foodId) {
		return itemRepository.getOne(foodId);
	}
	
	public Food createFood(Food food) {
		return itemRepository.save(food);
	}
	
	public boolean deleteFood(int foodId)  {
		Food food = itemRepository.getOne(foodId);
		if (food!=null) {
			itemRepository.deleteById(foodId);
			return true;
		}
		else
			return false;
	}
}
