package com.tomato.spring;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tomato.spring.bean.RatingView;
import com.tomato.spring.bean.SearchCriteria;
import com.tomato.spring.model.Rating;
import com.tomato.spring.model.Restaurant;
import com.tomato.spring.service.TomatoService;

@Controller
public class TomatoController {

	private static final Logger logger = LoggerFactory.getLogger(TomatoController.class);

	private TomatoService tomatoService;

	@Autowired(required = true)
	@Qualifier(value = "tomatoService")
	public void setTomatoService(TomatoService ts) {
		this.tomatoService = ts;
	}

	@RequestMapping(value = "/restaurants", method = RequestMethod.GET)
	public String listRestaurants(Model model) {
		try {
			model.addAttribute("restaurant", new Restaurant());
			model.addAttribute("listRestaurants", this.tomatoService.listRestaurants());
			return "restaurants";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "exception";
		}
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String viewRestaurant(@PathVariable("id") int id, Model model) {
		try {
			model.addAttribute("ratings", this.tomatoService.getReviews(id));
			model.addAttribute("restaurant", this.tomatoService.getRestaurant(id));
			model.addAttribute("listRestaurants", this.tomatoService.listRestaurants());
			return "restaurants";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "exception";
		}
	}

	@RequestMapping(value = "/Restaurant/Search")
	public String searchRestaurants(@ModelAttribute("searchCriteria") SearchCriteria criteria, Model model) {
		try {
			model.addAttribute("searchCriteria", criteria);
			model.addAttribute("listRestaurants", this.tomatoService.searchRestaurants(criteria));
			return "restaurants";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "exception";
		}
	}

	@RequestMapping(value = "/Rating/add")
	public String addRatings(@ModelAttribute("ratingView") RatingView view, Model model) {

		try {
			// model.addAttribute("ratings", new Ratings());
			Rating rating;
			int rest_id = view.getRestId();
			String user = view.getuName();
			List<Rating> ratings = new ArrayList<Rating>();
			if (view.getAmbRating() != null) {
				rating = new Rating();
				rating.setName("Ambeience");
				rating.setRating(view.getAmbRating());
				rating.setRestaurantID(rest_id);
				rating.setReview(view.getReview());
				rating.setUserId(user);
				ratings.add(rating);
			}

			if (view.getServiceRating() != null) {
				rating = new Rating();
				rating.setName("Service");
				rating.setRating(view.getServiceRating());
				rating.setRestaurantID(rest_id);
				rating.setReview(view.getReview());
				rating.setUserId(user);
				ratings.add(rating);
			}

			if (view.getFoodRating() != null) {
				rating = new Rating();
				rating.setName("Food");
				rating.setRating(view.getFoodRating());
				rating.setRestaurantID(rest_id);
				rating.setReview(view.getReview());
				rating.setUserId(user);
				ratings.add(rating);
			}

			this.tomatoService.addRating(ratings);
			model.addAttribute("ratings", this.tomatoService.getReviews(rest_id));
			model.addAttribute("restaurant", this.tomatoService.getRestaurant(rest_id));
			model.addAttribute("listRestaurants", this.tomatoService.listRestaurants());
			return "restaurants";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "exception";
		}
	}

}
