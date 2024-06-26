package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.domain.Gender;
import main.java.domain.Restaurant;
import main.java.domain.User;
import main.java.service.RestaurantService;
import main.java.service.UserService;

public class Main {

	private static Map<String, User> usersMap;
	private static Map<String, Restaurant> restaurantsMap;
	private static UserService userService;
	private static RestaurantService restaurantService;
	private static User loggedInUser;
	public static void main(String[] args) {
			
		System.out.println("Foodkart app started");
		usersMap = new HashMap();
		restaurantsMap = new HashMap();
		userService = new UserService();
		restaurantService = new RestaurantService();
		
		registerUser("user1", Gender.MALE, "1234", "100");
		registerUser("user2", Gender.MALE, "1234", "100");
		registerUser("user3", Gender.FEMALE, "1234", "101");
		
		loginUser("user1");
		
		registerRestaurant("FOODPARK1", List.of("123", "321"), List.of("chola"), List.of(100), List.of(3));
		registerRestaurant("FOODPARK2", List.of("100", "101"), List.of("dahi"), List.of(200), List.of(3));
		registerRestaurant("FOODPARK3", List.of("200", "201"), List.of("papri"), List.of(300), List.of(3));
		
		updateRestaurantFoodQuantity("FOODPARK2", 2);
		updateRestaurantFoodQuantity("FOODPARK1", 2);
		
		reviewRestaurant("FOODPARK2", "user1", "AVG food", 3);
		reviewRestaurant("FOODPARK2", "user2", "AVG food", 3);
		
		printRestaurantByRateValue();
		
		placeOrder("user1", "FOODPARK2", 1);
		placeOrder("user1", "FOODPARK2", 1);
		placeOrder("user1", "FOODPARK1", 1);
		placeOrder("user1", "FOODPARK1", 1);
		placeOrder("user1", "FOODPARK1", 1);
		placeOrder("user1", "FOODPARK2", 1);
		
		System.out.println("Foodkart app stoped");
	}
	private static void placeOrder(String userId, String restaurantName, int quantity) {
		restaurantService.placeOrder(usersMap.get(userId), restaurantsMap.get(restaurantName), quantity);
	}
	private static void printRestaurantByRateValue() {
		restaurantService.printRestaurantByRateValue(restaurantsMap);
	}
	private static void reviewRestaurant(String restaurantName, String userId, String comment, int rate) {
		restaurantService.addRating(restaurantsMap.get(restaurantName), userId, comment, rate);
		System.out.println("Rating added successfully, "+restaurantName);
	}
	private static void updateRestaurantFoodQuantity(String restaurantName, int quantity) {
		restaurantService.updateRestaurantFoodQuantity(restaurantsMap.get(restaurantName), restaurantName, quantity);
		System.out.println("Updating Restaurant Food Quantity Successfull, "+restaurantName);
	}
	private static void registerRestaurant(String restaurantName, List<String> list, List<String> foods, List<Integer> prices,
			List<Integer> quantities) {
		restaurantsMap.put(restaurantName, restaurantService.registerRestaurant(restaurantName, list, foods, prices, quantities));
		System.out.println("Registering Restaurant Successfull, "+restaurantName);
	}
	private static void loginUser(String userId) {
		System.out.println("Logging started");
		if(!userService.validateUser(userId, usersMap)) {
			System.out.println("Logging failed");
		}
		loggedInUser=usersMap.get(userId);
		System.out.println("Logging Successfull, "+userId);
	}
	private static void registerUser(String userId, Gender male, String phoneNum, String pincode) {
		usersMap.put(userId, userService.createUser(userId, male, phoneNum, pincode));
		System.out.println("User Registered successfully. "+userId);
	}

}
