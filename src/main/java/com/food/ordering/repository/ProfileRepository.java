package com.food.ordering.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.ordering.entity.Profile;
import com.food.ordering.entity.User;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	Optional<Profile> findByUserId(User user);
}
