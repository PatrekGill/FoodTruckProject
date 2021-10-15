package com.skilldistillery.foodtruck;

public class FoodTruck {
	private static long highestTruckId;
	private long truckId;
	private String name;
	private String foodType;
	private int rating;
	
	public FoodTruck(String name_, String foodType_, int rating_) {
		setTruckId(getHighestTruckId());
		incrementHighestObjectId();		
		
		setName(name_);
		setFoodType(foodType_);
		setRating(rating_);
	}
	
	private void setTruckId(long truckId) {
		this.truckId = truckId;
	}
	public long getTruckId() {
		return truckId;
	}
	
	private void incrementHighestObjectId() {
		FoodTruck.highestTruckId += 1;
	}
	private long getHighestTruckId() {
		return highestTruckId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Name: ").append(getName());
		stringBuilder.append(" | Food Type: ").append(getFoodType());
		stringBuilder.append(" | Rating: ").append(getRating());
		stringBuilder.append(" | ID: ").append(getTruckId());
		
		return stringBuilder.toString();
	}
}

