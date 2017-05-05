package com.tomato.spring.dao;

import java.util.List;

import com.tomato.spring.bean.SearchCriteria;
import com.tomato.spring.model.Rating;
import com.tomato.spring.model.Restaurant;

public interface TomatoDAO {
	
	public List<Restaurant> listRestaurants();
	
	public List<Rating> listRatings(int id);
	
	public void addRating(List<Rating> lrating);
	
	public List<Restaurant> listRestaurants(SearchCriteria criteria);
	
	public Restaurant getRestaurantById(int id);
	
	public double calculateAvgForRest(int id,String type);	
	
	public void updateRestaurant(Restaurant restaurant);

}
