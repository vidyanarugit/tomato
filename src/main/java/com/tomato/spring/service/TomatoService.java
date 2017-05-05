package com.tomato.spring.service;

import java.util.List;

import com.tomato.spring.bean.SearchCriteria;
import com.tomato.spring.model.Rating;
import com.tomato.spring.model.Restaurant;

public interface TomatoService {
	
	public List<Restaurant> listRestaurants();
	
	//public void addRestaurant();
	
	public List<Rating> getReviews(int restId);
	
	public void addRating(List<Rating> rating);
	
	public List<Restaurant> searchRestaurants(SearchCriteria criteria);

	public Restaurant getRestaurant(int id);
}
