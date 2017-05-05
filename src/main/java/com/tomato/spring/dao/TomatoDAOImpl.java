package com.tomato.spring.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tomato.spring.bean.SearchCriteria;
import com.tomato.spring.model.Rating;
import com.tomato.spring.model.Restaurant;

@Repository
public class TomatoDAOImpl implements TomatoDAO {

	private static final Logger logger = LoggerFactory.getLogger(TomatoDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Restaurant> listRestaurants() {

		Session session = this.sessionFactory.getCurrentSession();
		List<Restaurant> restaurants = session.createQuery("from Restaurant order by rating desc").list();

		return restaurants;

	}

	@Override
	public List<Rating> listRatings(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Rating> category = session.createQuery("from Rating r where r.restaurantID = " + id).list();
		return category;

	}

	@Override
	public void addRating(List<Rating> ratingList) {
		Iterator<Rating> itr = ratingList.iterator();
		Session session = this.sessionFactory.getCurrentSession();
		// String cat = rating.getName();
		// String review = rating.getReview();
		int rest_id = 0;
		// String user = rating.getUserId();

		while (itr.hasNext()) {
			Rating rating = itr.next();
			rest_id = rating.getRestaurantID();

			EntityManager em;
			session.save(rating);

		}

	}

	public void updateRating(List<Rating> rating, int rest_id) {
		Session session = this.sessionFactory.getCurrentSession();
		int avgrate = 0;
		HashMap<Integer, Integer> t = new HashMap<>();
		int f = 0;
		int a = 0;
		int s = 0;
		Iterator<Rating> restItr = ((List<Rating>) rating).iterator();
		while (restItr.hasNext()) {
			Rating r = restItr.next();
			if (r.getName().equalsIgnoreCase("food"))
				f++;
			if (r.getName().equalsIgnoreCase("service"))
				s++;

		}

		session.update("restaurant set rating =" + rest_id + " where rest_id = " + avgrate);
		logger.info("Rating updated successfully, Rating Details for restaurant=" + rest_id);

	}

	@Override
	public List<Restaurant> listRestaurants(SearchCriteria criteria) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Restaurant.class);
		cr.add(Restrictions.ge("avgFood", criteria.getFoodid()));
		cr.add(Restrictions.ge("avgServ", criteria.getServid()));
		cr.add(Restrictions.ge("avgAmb", criteria.getAmbid()));
		return cr.list();
	}

	@Override
	public Restaurant getRestaurantById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Restaurant.class);
		cr.add(Restrictions.idEq(id));
		return (Restaurant) cr.uniqueResult();
	}

	@Override
	public double calculateAvgForRest(int id, String type) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Rating.class);
		cr.add(Restrictions.eq("restaurantID", id));
		cr.add(Restrictions.eq("name", type));
		cr.setProjection(Projections.countDistinct("userId"));
		cr.setProjection(Projections.avg("rating"));
		List<Object> list = cr.list();
		if(list != null && !list.isEmpty() && list.get(0) != null){
		return (double)list.get(0);
		}else{
			return 0.0;
		}
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(restaurant);
		logger.info("Update restaurant successfully");
	}
}
