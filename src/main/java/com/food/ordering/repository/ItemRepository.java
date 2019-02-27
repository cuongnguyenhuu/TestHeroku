package com.food.ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.ordering.entity.Food;

@Repository
public interface ItemRepository extends JpaRepository<Food, Integer> {

}
