package com.food.ordering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.ordering.entity.Profile;
import com.food.ordering.entity.User;
import com.food.ordering.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	ProfileRepository profileRepository;
	
	public List<Profile> getAllProfile(){
		return profileRepository.findAll();
	}
	
	public Profile findProfileByUserId(User user) {
		return profileRepository.findByUserId(user).get();
	}
	
	public Profile createProfile(Profile profile) {
		return profileRepository.save(profile);
	}
	
	public boolean deleteProfile(int profileId)  {
		Profile profile = profileRepository.getOne(profileId);
		if (profile!=null) {
			profileRepository.deleteById(profileId);
			return true;
		}
		else
			return false;
	}
}
