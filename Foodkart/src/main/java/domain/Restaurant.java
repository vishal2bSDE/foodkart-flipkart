package main.java.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Restaurant {

	private String name;
	private Set<String> servicablePincodes;
	private Map<String, Integer> foodPriceMap;
	private Map<String, Integer> foodQuantityMap;
	private List<Rating> ratings;
	private String mainFood;
	private int totalRating;
	
	public Restaurant(String name, Set<String> servicablePincodes, List<String> foods, List<Integer> prices, List<Integer> quantities) {
		super();
		this.name = name;
		this.servicablePincodes = servicablePincodes;
		totalRating =0;
		ratings=new ArrayList();
		populatefoodPriceQuantityMap(foods, prices, quantities);
	}
	private void populatefoodPriceQuantityMap(List<String> foods, List<Integer> prices, List<Integer> quantities) {
		foodPriceMap=new HashMap();
		foodQuantityMap=new HashMap();
		for(int i=0;i<foods.size();i++) {
			String food = foods.get(i);
			int price = prices.get(i);
			int quantity = quantities.get(i);
			mainFood = foods.get(0);
			foodPriceMap.put(food, price);
			foodQuantityMap.put(food, quantity);
		}
	}
	
	public String getMainFood() {
		return mainFood;
	}
	public void setMainFood(String mainFood) {
		this.mainFood = mainFood;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getServicablePincodes() {
		return servicablePincodes;
	}
	public void setServicablePincodes(Set<String> servicablePincodes) {
		this.servicablePincodes = servicablePincodes;
	}
	public Map<String, Integer> getFoodPriceMap() {
		return foodPriceMap;
	}
	public void setFoodPriceMap(Map<String, Integer> foodPriceMap) {
		this.foodPriceMap = foodPriceMap;
	}
	public Map<String, Integer> getFoodQuantityMap() {
		return foodQuantityMap;
	}
	public void setFoodQuantityMap(Map<String, Integer> foodQuantityMap) {
		this.foodQuantityMap = foodQuantityMap;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public void updatedFoodQuantity(int quantity) {
		foodQuantityMap.put(mainFood, quantity);
	}
	public int getTotalRating() {
		return totalRating;
	}
	public void setTotalRating(int totalRating) {
		this.totalRating = totalRating;
	}
	public void updateTotalRating(int totalRating) {
		this.totalRating += totalRating;
	}
}
