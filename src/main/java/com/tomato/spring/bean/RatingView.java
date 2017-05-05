package com.tomato.spring.bean;

public class RatingView {
	
	
	String serviceRating;
	
	String foodRating;
	
	String ambRating;
	
	int restId;
	
	String review;
	
	String uName;
	
	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getServiceRating() {
		return serviceRating;
	}

	public void setServiceRating(String serviceRating) {
		this.serviceRating = serviceRating;
	}

	public String getFoodRating() {
		return foodRating;
	}

	public void setFoodRating(String foodRating) {
		this.foodRating = foodRating;
	}

	public String getAmbRating() {
		return ambRating;
	}

	public void setAmbRating(String ambRating) {
		this.ambRating = ambRating;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	

	
}
