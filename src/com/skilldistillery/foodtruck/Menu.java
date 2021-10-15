package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class Menu {
	public FoodTruck askForTruck(Scanner scanner){
		FoodTruck truck = null;
		
		String truckName = getNextLine(scanner,"Enter in the truck's name or 'quit' to end program: ");
		if (!truckName.equalsIgnoreCase("quit")) {
			int truckRating = getNextInt(scanner, "Enter in the truck's rating: ");
			String truckFoodType = getNextLine(scanner,"Enter in the truck's food type: ");
			
			truck = new FoodTruck(truckName, truckFoodType, truckRating);
		}
			
		return truck;
	}
	
	private void printInvalidEntry() {
		System.out.println("Invalid entry, try again please...\n");
	}
	
	private int getNextInt(Scanner scanner, String prompt) {
		int input;
		while (true) {
			System.out.print(prompt);
			
			boolean hasNext = scanner.hasNextInt();
			if(hasNext) {
				input = scanner.nextInt();
				scanner.nextLine();
				
				break;
				
			} else {
				printInvalidEntry();
				scanner.nextLine(); // stop looping from hasNextInt

			}

		}
		
		return input;
	}
	
	private String getNextLine(Scanner scanner, String prompt) {
		String input;
		while (true) {
			System.out.print(prompt);
			if(scanner.hasNextLine()) {
				input = scanner.nextLine();
				break;
				
			} else {
				printInvalidEntry();
				
			}
		}
		
		return input;
	}
	
	private void printDetailsMenu() {
		System.out.println("===========================================");
		System.out.println("1. List all existing food trucks.");
		System.out.println("2. See the average rating of food trucks.");
		System.out.println("3. Display the highest-rated food truck.");
		System.out.println("4. Quit the program.");
		System.out.println("===========================================");
	}
	
	private void listAllFoodTrucks(FoodTruck[] truckArray) {
		boolean foundNonNull = false;
		for (FoodTruck foodTruck : truckArray) {
			if (foodTruck != null) {
				foundNonNull = true;
				System.out.println(foodTruck.toString());
			}
		}
		
		if (!foundNonNull) {
			System.out.println("There were no trucks to display...");
		}
	}
	
	private void showAverageRating(FoodTruck[] truckArray) {
		int average = 0;
		int numOfNonNull = 0;
		for (FoodTruck foodTruck : truckArray) {
			if (foodTruck != null) {
				numOfNonNull++;
				average += foodTruck.getRating();
			}
		}
		
		if (numOfNonNull == 0) {
			System.out.println("There were no rated trucks...");
		} else {
			System.out.println("Average Rating: " + (average / numOfNonNull));
		}
		
		
	}
	
	private void displayHighestRated(FoodTruck[] truckArray) {
		FoodTruck highestTruck = null;
		int highestRating = -1;
		for (FoodTruck foodTruck : truckArray) {
			if (foodTruck != null) {
				int truckRating = foodTruck.getRating();
				if (highestRating < truckRating) {
					highestTruck = foodTruck;
					highestRating = truckRating;
				}
			}
		}
		
		if (highestTruck == null) {
			System.out.println("There are no trucks, therefore none are the highest rated...");
		} else {
			System.out.println("The highest rated truck is:");
			System.out.println(highestTruck.toString());
		}
	}
	
	public void detailsMenuLoop(Scanner scanner, FoodTruck[] truckArray) {
		boolean quit = false;
		while (!quit) {
			printDetailsMenu();
			int choice = getNextInt(scanner, "Your choice: ");
			
			switch (choice) {
				case 1:{
					listAllFoodTrucks(truckArray);
					break;
				}
				case 2:{
					showAverageRating(truckArray);
					break;
				}
				case 3:{
					displayHighestRated(truckArray);
					break;
				}
				case 4:{
					quit = true;
					break;
				}
					
				default:{
					printInvalidEntry();
					break;
				}	
			}
			// just for easier reading of console
			System.out.println();
		}
		
		System.out.println("Goodbye");
	}
	
	
}
