package com.tomato.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="restaurants")
//@NamedQueries({
//	@NamedQuery(name="updateavgrating", query = "update Restaurant r set r.rating = : avgrating where r.id = :id")})
public class Restaurant {
	
	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "name", nullable= false)
	private String name;
	
	@Column(name="address")
	private String address; 
	
	@Column(name="city")
	private String city;
	
	@Column(name="image")
	private String image;
	
	@Column(name = "rating")
	private double avgRating;
	
	@Column(name = "food")
	private double avgFood;
	
	public double getAvgServ() {
		return avgServ;
	}

	public void setAvgServ(double avgServ) {
		this.avgServ = avgServ;
	}

	public double getAvgAmb() {
		return avgAmb;
	}

	public void setAvgAmb(double avgAmb) {
		this.avgAmb = avgAmb;
	}

	@Column(name = "service")
	private double avgServ;
	
	@Column(name = "ambience")
	private double avgAmb;
	
	/*@OneToMany(mappedBy="restaurant", targetEntity=Rating.class)
	private List<Rating> ratings;
	
	
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}*/

	public double getAvgFood() {
		return avgFood;
	}

	public void setAvgFood(double avgFood) {
		this.avgFood = avgFood;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	

}
