package main.java.domain;

public class Order {

	private String restaurantName;
	private String foodName;
	private int quantity;
	
	
	public Order(String restaurantName, String foodName, int quantity) {
		super();
		this.restaurantName = restaurantName;
		this.foodName = foodName;
		this.quantity = quantity;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
