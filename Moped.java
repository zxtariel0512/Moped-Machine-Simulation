
import java.util.Random;

/**
 * A program to define all properties and functions to simulate a virtual Moped.
 * @author Xintong Zhu (xz1991)
 * @version 0.2
 */
public class Moped {
	
	// properties
	
	/**
	 * The street name of the virtual moped's current location.
	 * All start at 10th street.
	 */
	private int street;
	
	/**
	 * The avenue name of the virtual moped's current location.
	 * All start at 5th avenue.
	 */
	private int avenue;
	
	/**
	 * The current orientation of the virtual moped.
	 */
	private int orientation;
	
	/**
	 * The total gas of the virtual moped with 1 gallon.
	 */
	private double gas = 1.0;
	
	/**
	 * Define the current direction of the virtual moped.
	 */
	private String direction;
	
	
	
	
	// actions
	
	/**
	 * Minus street number if go south.
	 */
	public void goSouth () {
		if (this.street == 1) {
			// out of the grid
			System.out.println("Sorry, you cannot straight on anymore because you have already been at 1st Street.");
		}
		else {
			this.street -= 1;
		}
	} // goSouth
	
	/**
	 * Increase street number if go north.
	 */
	public void goNorth() {
		if (this.street == 200) {
			// out of the grid
			System.out.println("Sorry, you cannot back up anymore because you have already been at 200th Street.");
		}
		else {
			this.street += 1;
		}		
	} // goNorth
	
	/**
	 * Minus avenue number if go east.
	 */
	public void goEast () {
		if (this.avenue == 1) {
			// out of the grid
			System.out.println("Sorry, you cannot go left anymore because you have already been at 1st Avenue.");
		}
		else {
			this.avenue -= 1;
		}
	} // goEast
	
	/**
	 * Increase avenue number if go west.
	 */
	public void goWest() {		
		if (this.avenue == 10) {
			// out of the grid
			System.out.println("Sorry, you cannot go right anymore because you have already been at 10th Avenue.");
		}
		else {
			this.avenue += 1;
		}		
	} // goWest
	
	/**
	 * Park the Moped.
	 */
	public void park () {
		System.out.println("The Moped is now parking on the sidewalk. The program quits.");
	} // park
	
	/**
	 * Consume the gas 0.05 per block.
	 */
	public void consumeGas () {
			this.gas -= 0.05;
	} // consumeGas
	
	/**
	 * Show the user the current situation of their gas consumption.
	 */
	public void howWeDoin () {
		if (this.gas > 0) 
			System.out.printf("The gas tank is currently %.0f%% full.\n", this.gas/1.0*100);
		else 
			System.out.printf("The gas tank is currently %d%% full.\n", 0);
	} // howWeDoin
	
	/**
	 * Fill up the gas again to 1 gallon;
	 */
	public void fillErUp() {
		this.gas = 1;
	} // fillErUp
	
	/**
	 * Lead the user to Petite Abeille and output the current location.
	 * @param currentStreetNumber An integer of current street number.
	 * @param currentAvenueNumber An integer of current avenue number.
	 * @param direction A Directions enum of current direction.
	 */
	public void homing() {
		biggerThan17: if (this.street > 17) {
			// current location is in the north of Petite Abeille
			// use a while loop to keep going south
			while (this.street != 17) {
				if (this.gas > 0) {
					this.street -= 1;
					consumeGas();
					System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
					checkAds(); // check the advertisements						
				} // gas
				else {
					System.out.println("Sorry, your Moped can no longer work because it runs out of gas. The program will quit.");
					System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
					checkAds(); // check the advertisements
					break biggerThan17;
				}				
			} // while loop
			// current street number is correct
			if (this.avenue > 6) {
				// current location is in the west of Petite Abeille
				// use a while loop to keep going east
				while (this.avenue != 6) {
					if (this.gas > 0) {
						this.avenue -= 1;
						consumeGas();
						System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
						checkAds(); // check the advertisements
					} // gas
					else {
						System.out.println("Sorry, your Moped can no longer work because it runs out of gas. The program will quit.");
						System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
						checkAds(); // check the advertisements
						break;
					}					
				} // while loop
				System.out.println("We have reached the Petite Abeille.  Enjoy your moules-frites.");
			} // if this.avenue > 6
			else if (this.avenue < 6) {
				// current location is in the east of Petite Abeille
				// use a while loop to keep going west
				while (this.avenue != 6) {
					if (this.gas > 0) {
						this.avenue += 1;
						consumeGas();
						System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
						checkAds(); // check the advertisements
					} // gas
					else {
						System.out.println("Sorry, your Moped can no longer work because it runs out of gas. The program will quit.");
						System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
						checkAds(); // check the advertisements
						break;
					}
				} // while loop
				System.out.println("We have reached the Petite Abeille.  Enjoy your moules-frites.");
			} // if this.avenus < 6
		} // if this.street > 17
		else smallerThan17: if (this.street < 17) {
			// current location is in the south of Petite Abeille
			// use a while loop to keep going north
			while (this.street != 17) {
				if (this.gas > 0) {
					this.street += 1;
					consumeGas();
					System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
					checkAds(); // check the advertisements
					
					
				} // gas
				else {
					System.out.println("Sorry, your Moped can no longer work because it runs out of gas. The program will quit.");
					System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + direction);
					checkAds(); // check the advertisements
					break smallerThan17;
				}				
			} // while loop
			// current street number is correct
			if (this.avenue > 6) {
			// current location is in the west of Petite Abeille
			// use a while loop to keep going east
			while (this.avenue != 6) {
				if (this.gas > 0) {
					this.avenue -= 1;
					consumeGas();
					System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
					checkAds(); // check the advertisements
				} // gas
				else {
					System.out.println("Sorry, your Moped can no longer work because it runs out of gas. The program will quit.");
					System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
					checkAds(); // check the advertisements
					break;
				}					
			} // while loop
			System.out.println("We have reached the Petite Abeille.  Enjoy your moules-frites.");
		} // if this.avenue > 6
			else if (this.avenue < 6) {
				// current location is in the east of Petite Abeille
				// use a while loop to keep going west
				while (this.avenue != 6) {
					if (this.gas > 0) {
						this.avenue += 1;
						consumeGas();
						System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
						checkAds(); // check the advertisements
					} // gas
					else {
						System.out.println("Sorry, your Moped can no longer work because it runs out of gas. The program will quit.");
						System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
						checkAds(); // check the advertisements
						break;
					} 
				} // while loop
				System.out.println("We have reached the Petite Abeille.  Enjoy your moules-frites.");
			} // if this.avenue < 6
		} // if this.street < 17 
		
		// current street number is correct
		else {
			// current street number is correct
			if (this.avenue > 6) {
				// current location is in the west of Petite Abeille
				// use a while loop to keep going east
				while (this.avenue != 6) {
					if (this.gas > 0) {
						this.avenue -= 1;
						consumeGas();
						System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
						checkAds(); // check the advertisements
					}
					else {
						System.out.println("Sorry, your Moped can no longer work because it runs out of gas. The program will quit.");
						System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
						checkAds(); // check the advertisements
						break;
					}					
				}
			}
			else if (this.avenue < 6) {
				// current location is in the east of Petite Abeille
				// use a while loop to keep going west
				while (this.avenue != 6) {
					if (this.gas > 0) {
						this.avenue += 1;
						consumeGas();
						System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
						checkAds(); // check the advertisements
					}
					else {
						System.out.println("Sorry, your Moped can no longer work because it runs out of gas. The program will quit.");
						System.out.println ("Now at " + this.street + "th St. and " + this.avenue + "th Ave, facing " + this.direction);
						checkAds(); // check the advertisements
						break;
					}
				}
			}
			else {
				// exactly at the Petite Abeille
				System.out.println ("You are now already at Petite Abeille!");
			}
		}
		
	
	} // homing
	
	/**
	 * Display the instruction of language the Moped can understand.
	 */
	public void help() {
		System.out.println("'go left'                go to left");
		System.out.println("'go right'               go to right");
		System.out.println("'straight on'            go staight on");
		System.out.println("'back up'                go back up");
		System.out.println("'how we doin'?           show the current gas situation");
		System.out.println("'fill 'er up'            refill the gas");
		System.out.println("'park'                   park the Moped and quit the program");
		System.out.println("'go to Petite Abeille'   go to Petite Abeille automatically");
		System.out.println("'help'                   show the instruction of this Moped");
	} // help
	
	
	
	// setters
	
	/**
	 * Set up the street number.
	 * @param streetNumber An integer of the street number.
	 */
	public void setStreet(int streetNumber) {
		this.street = streetNumber;
	} // setStreet
	
	/**
	 * Set up the avenue number.
	 * @param avenueNumber An integer of the avenue number.
	 */
	public void setAvenue (int avenueNumber) {
		this.avenue = avenueNumber;
	} // setAvenue
	
	/**
	 * Set up the orientation.
	 * @param currentOrientation An integer of the current orientation.
	 */
	public void setOrientation (int currentOrientation) {
		this.orientation = currentOrientation;
	} // setOrientation
	
	/**
	 * Set up the direction.
	 * @param currentDirection A string of the current direction.
	 */
	public void setDirection (String currentDirection) {
		this.direction = currentDirection;
	} // setDirection
	
	/**
	 * Set up the Moped in one time.
	 * @param street An integer of the street number.
	 * @param avenue An integer of the avenue number.
	 * @param orientation An integer of the orientation degree.
	 * @param direction A String of the direction.
	 */
	public void setMoped (int street, int avenue, int orientation, String direction) {
		setStreet(street);
		setAvenue(avenue);
		setOrientation(orientation);
		setDirection(direction);
	} // setMoped
	
	
	
	// change the directions as the Moped move.
	
	/**
	 * Add 90 if go right
	 */
	public void goRightOrientation() {
		if (this.orientation == 360) {
			this.orientation= 0;
		}
		this.orientation += 90;
		if (this.orientation== 360) {
			this.orientation = 0;
		}
	} // goRightOrientation
	
	/**
	 * Minus 90 if go left
	 */
	public void goLeftOrientation() {
		if (this.orientation == 0) {
			this.orientation = 360;
		}
		this.orientation -= 90;
	} // goLeftOrientation
	
	/**
	 * Find the current direction based on the face orientation.
	 */
	public void findCurrentDirection() {
		switch (this.orientation) {
			case (0):   this.direction = "North"; break;
			case (90):  this.direction = "East"; break;
			case (180): this.direction = "South"; break;
			case (270): this.direction = "West"; break;
		}
	} // findCurrentDirection
	
	/**
	 * Move back up based on different directions.
	 */
	public void moveBackUp() {
		switch (this.direction) {
		case ("North"): goSouth(); break;
		case ("South"): goNorth(); break;
		case ("East"):  goWest();  break;
		case ("West"):  goEast();  break;
		}
		consumeGas();
	} // moveBackUp
	
	/**
	 * Move straight on based on different directions.
	 */
	public void moveStraightOn() {
		switch (this.direction) {
		case ("North"): goNorth(); break;
		case ("South"): goSouth(); break;
		case ("East"):  goEast();  break;
		case ("West"):  goWest();  break;
		}
		// consume the gas
		consumeGas();
	} // moveStraightOn
	
	/**
	 * Move to right based on different directions.
	 */
	public void moveToRight() {
		switch (this.direction) {
		case ("North"): goEast(); break;
		case ("South"): goWest(); break;
		case ("East"): goSouth(); break;
		case ("West"): goNorth(); break;
		}
		consumeGas();
		goRightOrientation();
	} // moveToRight
	
	/**
	 * Move to left based on different directions.
	 */
	public void moveToLeft() {
		switch (this.direction) {
		case("North"): goWest(); break;
		case("South"): goEast(); break;
		case("East"): goNorth(); break;
		case("West"): goSouth(); break;
		}
		consumeGas();
		goLeftOrientation();
	} // moveToLeft
	
	
	
	
	
	// getters
	
	/**
	 * Get the street number.
	 * @return An integer of the street number.
	 */
	public int getStreet() {
		return this.street;
	} // getStreet
	
	/**
	 * Get the avenue number.
	 * @return An integer of the avenue number.
	 */
	public int getAvenue() {
		return this.avenue;
	} // getAvenue
	
	/**
	 * Get the current orientation.
	 * @return An integer of the current orientation.
	 */
	public int getOrientation() {
		return this.orientation;
	} // getOrientation
	
	/**
	 * Get the current direction.
	 * @return A String of the current direction.
	 */
	public String getDirection() {
		return this.direction;
	} // getDirection
	
	/**
	 * Get the rest of gas.
	 * @return A float of rest of gas.
	 */
	public double getGas() {
		return this.gas;
	} // getGas
	
	
	
	
	// set up advertisements
	
	/**
	 * Check the ads based on street and avenues number.
	 */
	public void checkAds() {
		// American Museum of Natural History
		if (this.street == 79 && this.avenue == 8)
			System.out.println("Did you know the American Museum of Natural History has abundent knowledge about lovely backyard wilderness and mysterious creatures in unseen ocean?");
		//  Memorial Sloan Kettering
		else if (this.street == 74 && this.avenue == 1)
			System.out.println("Did you know the Memorial Sloan Kettering has specialists who treat every type of cancer, including the most important one--yours?");
		// The Strand
		else if (this.street == 12 && this.avenue == 4)
			System.out.println("Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?");
		// Fayda Coffee Tea Cookies Cake
		else if (this.street == 3 && this .avenue == 6)
			System.out.println("Did you know the Fayda Coffee Tea Cookies Cake have various lovely and tasty buns and pastries, and is offering BUY 10 GETS 3 FREE activity right now?");
	} // checkAds
	
	
	
	/**
	 * Make a random move through random number picking up.
	 */
	public void moveRandom() {
		// pick up a random integer between 0 to 3
		Random rand = new Random();
		int randMove = rand.nextInt(4);
		// check the gas
		if (this.gas <= 0)
			fillErUp(); // fill it up if no gas
		// make the move based on the random number
		// use a while loop to keep the Moped always inside th grid
		int insideTheGrid = 0; // set a flag
		while (insideTheGrid == 0) {
			switch(randMove) {
				case(0): moveBackUp(); break; // move back up for 0
				case(1): moveStraightOn(); break; // move straight on for 1
				case(2): moveToRight(); break; // move to right for 2
				case(3): moveToLeft(); break; // move to right for 3
			} // switch randMove
			// check whether the Moped is still in the grid
			if (this.street <= 200 || this.avenue <= 10 || this.street >= 1 || this.avenue >= 1) {
				insideTheGrid = 1;
			} // if check				
		} // while loop
		
		
	} // moveRandom

	
} // class
