package main.java.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import main.java.domain.Rating;
import main.java.domain.Restaurant;
import main.java.domain.User;

public class RestaurantService {

	private static UserService userService;
	
	public RestaurantService() {
		userService = new UserService();
	}
	
	public Restaurant registerRestaurant(String restaurantName, List<String> list, List<String> foods, List<Integer> prices, List<Integer> quantity) {
		System.out.println("Registering Restaurant started");
		return new Restaurant(restaurantName, new HashSet(list), foods, prices, quantity);
	}

	public void updateRestaurantFoodQuantity(Restaurant restaurant, String restaurantName, int quantity) {
		System.out.println("Updating Restaurant Food Quantity started");
		String food = restaurant.getMainFood();
		restaurant.getFoodQuantityMap().put(food, quantity);
	}

	public void addRating(Restaurant restaurant, String userId, String comment, int rate) {
		System.out.println("Rating adding started, "+ restaurant.getName());
		restaurant.getRatings().add(new Rating(userId, comment, rate));
		restaurant.updateTotalRating(rate);
	}

	public void printRestaurantByRateValue(Map<String, Restaurant> restaurantsMap) {
		System.out.println("Printing Restaurant by rate value");
		restaurantsMap.values().stream().sorted((r1, r2)->{
			if(r2.getRatings().size()==0 && r1.getRatings().size()==0)return 0;
			if(r1.getRatings().size()==0 )return 1;
			if(r2.getRatings().size()==0 )return -1;
			return (r2.getTotalRating()/r2.getRatings().size()) - (r1.getTotalRating()/r1.getRatings().size());
		}).forEach(restaurant -> {
			System.out.println(restaurant.getName()+" - "+ restaurant.getMainFood());
		});
		
	}

	public void placeOrder(User user, Restaurant restaurant, int quantity) {
		String food = restaurant.getMainFood();
		if(!restaurant.getServicablePincodes().contains(user.getPincode()) || restaurant.getFoodQuantityMap().get(food)<quantity) {
			System.out.println("Order cant be placed "+restaurant.getName()+" - "+food);
			return;
		}
		int currQuatity=restaurant.getFoodQuantityMap().get(food);
		restaurant.getFoodQuantityMap().put(food, currQuatity-quantity);
		userService.addToUserPlaedOrders(user, restaurant.getName(), food, quantity);
		System.out.println("Order placed "+restaurant.getName()+" - "+food);
	}
}
