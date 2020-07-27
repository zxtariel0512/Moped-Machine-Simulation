package edu.nyu.cs.xz1991.assignment5;

import java.util.Scanner; // import the Scanner

/**
 * A program to test the simulation of the virtual Moped and interact with the user.
 * With extra credits inside.
 * @author Xintong Zhu (xz1991)
 * @version 0.2
 */
public class TestDrive {
	
	/**
	 * A method to interact with the user and control the virtual Moped.
	 * @param args Any argument provided while running the program.
	 * @return There is no value to return because the method is defined as void.
	 */
	public static void main (String [] args) {
		
		// set up the user Moped
		Moped userMoped = new Moped();
		userMoped.setMoped(10, 5, 180, "South"); // start at 10th St. 5th Ave, facing south
		
		// set up the two drunk drivers
		Moped drunkDriver1 = new Moped();
		Moped drunkDriver2 = new Moped();
		drunkDriver1.setMoped(10, 5, 180, "South");
		drunkDriver2.setMoped(10, 5, 180, "South"); // both start at 10th St. 5th Ave, facing south
		
		// create the Scanner object
		Scanner input = new Scanner (System.in);
				
		System.out.println("Thanks for jumping on the moped.  We're currently parked outside Dr. Rossinsky DDS's office at 10th St. and 5th Ave.  May I say your teeth look very clean.");
		System.out.println("What would you like to do?  At any time, say \"help\" for assistance.");
		
		// use a while loop to keep prompting the user
		String userChoiceRaw = input.nextLine();
		String userChoice = userChoiceRaw.toLowerCase();
		if (userChoice.equals("park")) {
					
			// quit the program directly
			userMoped.park();	
					
		}
		else {
			
			while (!userChoice.equals("park")) {
				
				// get the current direction
				String direction = userMoped.getDirection();
				// get the rest of gas
				double gas = userMoped.getGas();

				if (userChoice.equals("back up") || userChoice.equals("straight on") || userChoice.equals("go right") || userChoice.equals("go left")) {
					
					// check the gas
					if (gas > 0) {
						// make the move
						switch (userChoice) {
						case("back up"): userMoped.moveBackUp(); break; // move back up
						case("straight on"): userMoped.moveStraightOn(); break; // move straight on
						case("go right"): userMoped.moveToRight(); break; // move to right
						case("go left"): userMoped.moveToLeft(); break; // move to left
						} // switch case
					}
					else {
						// run out of gas
						System.out.println("Sorry, your Moped can no longer work because it runs out of gas.");
						break;
					}
					// get the street number, avenue number, direction
					int streetNumber = userMoped.getStreet();
					int avenueNumber = userMoped.getAvenue();
					userMoped.findCurrentDirection();
					direction = userMoped.getDirection();
					// display the output
					System.out.println ("Now at " + streetNumber + "th St. and " + avenueNumber + "th Ave, facing " + direction);
					// check the advertisements
					userMoped.checkAds(); 
				} // if move
				
				// check the gas situation
				else if (userChoice.equals("how we doin'?")) {
					
					userMoped.howWeDoin();
					
				} // if check the gas
				
				// fill up the gas
				else if (userChoice.equals("fill 'er up")) {
					
					userMoped.fillErUp();
					System.out.println("Congratulations! Your gas is filled up to 1 gallon again!");
					
				} // if fill up
				
				// ask for the command lines
				else if (userChoice.equals("help")) {
					
					userMoped.help();
					
				} // if help
				
				// homing directly
				else if (userChoice.equals("go to petite abeille")) {
				
					// call the method
					userMoped.homing();
					// check out whether the gas is used out on its way
					int userCurrentStreet = userMoped.getStreet();
					int userCurrentAvenue = userMoped.getAvenue();
					if (!(userCurrentStreet == 17 && userCurrentAvenue == 6)) {
						// the gas is used out on its way, the program should quit
						break;
					}
					
				} // go to Petite Abeille
				
				else {
					
					System.out.println("Sorry, I don't understand. Please enter again.");
					
				} // invalid input
				
				
				
				
				// 2 drunk drivers make a random move
				drunkDriver1.moveRandom();
				drunkDriver2.moveRandom();
				
				// get their current information of location
				int drunkDriver1Street = drunkDriver1.getStreet();
				int drunkDriver1Avenue = drunkDriver1.getAvenue();
				int drunkDriver2Street = drunkDriver2.getStreet();
				int drunkDriver2Avenue = drunkDriver2.getAvenue();
				// find the direction and get it
				drunkDriver1.findCurrentDirection();
				drunkDriver2.findCurrentDirection();
				String drunkDriver1Direction = drunkDriver1.getDirection();
				String drunkDriver2Direction = drunkDriver2.getDirection();
				
				// display the result
				System.out.println ("Drunk driver No.1 now at " + drunkDriver1Street + "th St. and " + drunkDriver1Avenue + "th Ave, facing " + drunkDriver1Direction);
				System.out.println ("Drunk driver No.2 now at " + drunkDriver2Street + "th St. and " + drunkDriver2Avenue + "th Ave, facing " + drunkDriver2Direction);

				// check whether crush
				int userStreet = userMoped.getStreet();
				int userAvenue = userMoped.getAvenue();
				if (drunkDriver1Street == userStreet && drunkDriver1Avenue == userAvenue) {
					// same location with driver1
					System.out.println("Oops! We are crushed by the drunk driver No.1! The program crashed down!");
					break;
				}
				else if (drunkDriver2Street == userStreet && drunkDriver2Avenue == userAvenue) {
					// same location with driver2
					System.out.println("Oops! We are crushed by the drunk driver No.2! The program crashed down!");
					break;
				}
				
				
				
				
				// prompt the user again and lower case all answers for case-insensitive aim
				userChoiceRaw = input.nextLine();
				userChoice = userChoiceRaw.toLowerCase();	
				
			} // while loop
			
			if (userChoice.equals("park")) {
				userMoped.park();
			} // if the user parks
		
			
		}
		input.close(); // close the input
			
			
		
	} // main
	
}
