package main.java.service;

import java.util.Map;

import main.java.domain.Gender;
import main.java.domain.Order;
import main.java.domain.User;

public class UserService {

	public User createUser(String userId, Gender gender, String phoneNum, String pinCode) {
		System.out.println("Started registering User "+userId);
		return new User(userId, gender, phoneNum, pinCode);
	}
	
	public void addOrderHistoryToUser(User user, String restaurantName, String food, int quantity) {
		user.getOrderHistory().add(new Order(restaurantName, food, quantity));
	}
	
	public boolean validateUser(String userId, Map<String, User> userMap) {
		return userMap.containsKey(userId);
	}

	public void addToUserPlaedOrders(User user, String name, String food, int quantity) {
		user.getOrderHistory().add(new Order(name, food, quantity));
		System.out.println("Order added to users history "+name+" - "+food);
	}
}
