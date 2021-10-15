package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		FoodTruck[] truckArray = new FoodTruck[5];
		
		Scanner scanner = new Scanner(System.in);
		Menu menu = new Menu();
		for (int i = 0; i < truckArray.length; i++) {
			System.out.println("\nTruck " + (i+1) + ":"); // space
			FoodTruck truck = menu.askForTruck(scanner);
			if (truck == null) {
				System.out.println("Stopping truck enter program...");
				break;
			}
			
			truckArray[i] = truck;
		}
		
		System.out.println();
		menu.detailsMenuLoop(scanner, truckArray);
		scanner.close();
	}

}
