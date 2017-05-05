package com.tomato.test;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

import com.tomato.spring.model.Restaurant;
import com.tomato.spring.service.TomatoService;
import com.tomato.spring.service.TomatoServiceImpl;

public class MyRestaurantTests extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	 @Test
	public void testListRestaurants(){
		try{
			TomatoService service = new TomatoServiceImpl();
			List<Restaurant> list = service.listRestaurants();
			for(Restaurant restaurant : list){
				System.out.println(restaurant.getName());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
