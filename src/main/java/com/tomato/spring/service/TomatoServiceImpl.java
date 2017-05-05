package com.tomato.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tomato.spring.bean.SearchCriteria;
import com.tomato.spring.dao.TomatoDAO;
import com.tomato.spring.model.Rating;
import com.tomato.spring.model.Restaurant;

public class TomatoServiceImpl implements TomatoService {
	
	
	private TomatoDAO tomatoDAO;
	
	public void setTomatoDAO(TomatoDAO tomatoDAO) {
		this.tomatoDAO = tomatoDAO;
	}

	@Override
	@Transactional
	public List<Restaurant> listRestaurants() {
		return this.tomatoDAO.listRestaurants();
	}

	// @Override
	// public void addRestaurant() {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	@Transactional
	public List<Rating> getReviews(int restId) {
		
		return this.tomatoDAO.listRatings(restId);
	}

	@Override
	@Transactional
	public void addRating(List<Rating> ratings) {
		this.tomatoDAO.addRating( ratings );
		Restaurant restaurant = this.tomatoDAO.getRestaurantById(ratings.get(1).getRestaurantID());
		if(restaurant != null){
		restaurant.setAvgAmb(this.tomatoDAO.calculateAvgForRest(restaurant.getId(),"Ambeience"));
		restaurant.setAvgFood(this.tomatoDAO.calculateAvgForRest(restaurant.getId(),"Food"));
		restaurant.setAvgServ(this.tomatoDAO.calculateAvgForRest(restaurant.getId(),"Service"));
		this.tomatoDAO.updateRestaurant( restaurant );
		}
	}

	@Override
	@Transactional
	public List<Restaurant> searchRestaurants(SearchCriteria criteria) {
		return this.tomatoDAO.listRestaurants(criteria);
	}

	@Override
	@Transactional
	public Restaurant getRestaurant(int id) {
		
		return this.tomatoDAO.getRestaurantById(id);
	}

	
	
}
