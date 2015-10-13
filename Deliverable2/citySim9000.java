//Tyler Kosmacki, TFK7
//Written alongside junit tests for cs1632: Software Quality Assurance
//Created a car that drives around a city in a random fashion given
//a road map in the assignment sheet: 
//Using locations array 0->1->2->Fourth Avenue
//						A  A
//					Meow|  |Chirp
//						v  v
//	  Fifth Avenue <-3<-4<-5
//compiling is annoying outside of eclipse, think this is how
//compile in directory above with javac citySim9000/citySim.java
//run with: java citySim9000/citySim
package citySim9000;

import java.util.Random;

public class citySim9000 {
	public static void main(String[] args) {
		String [] locations = {"Mall","Bookstore","Outside City","Outside City","Coffee Shop", "University"};
		int seed = handleArgs(args);
		if (seed<0){
			System.exit(seed);
		}
		Random generator = new Random(seed); //generator for car start location
		
		for(int i = 0; i < 5 ; i++){ //WILL RUN 5 TIMES FOR 5 DIFFERENT CARS
			int turn = 0; //used to allow driver to enter city if starting from outside
			Driver driver = new Driver(); //initializing a driver object
			
			int rand = generator.nextInt(6); //generates first move
			driver.setCurrent(rand); //sets initial start point
			System.out.println("Driver " + i + " starts from " + locations[rand] + ".");
			
			while((driver.getCurrent() != 2 && driver.getCurrent() != 3) || turn == 0){ //while its not outside the city
				rand = generator.nextInt(2);
				int nextMove = nextMove(rand,driver,turn);
				if (nextMove == -1){
					System.out.println("nextMove Failed.");
					System.exit(-1);
				}
				
				driver.setNext(nextMove);
				String via = via(driver);
				System.out.println("Driver " + i + " heading from " + locations[driver.getCurrent()] + " to " + locations[nextMove] + " via " + via + ".");
				driver.setCurrent(nextMove);
				turn++;
			}
			
			System.out.println("Driver has left the city.");
			System.out.println();
		}
	}
	
	//checks that the number of arguments is correct and that it is a string that can be parsed to an int
	//satisfies FUN-ARGS requirement
	public static int handleArgs(String[] args){
		if( args.length != 1){
			System.out.println("Incorrect number of arguments provided on command line. Should be java citySim9000 [seedNum]");
			return -1;
		}
		int seed = 0; //initialization required
		try{
			seed = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e){
			System.out.println("Invalid argument entered. [Seed] Argument must be an integer.");
			return -2;
		}
		return seed;
	}

	//checks which street the driver used
	public static String via(Driver driver){
		int loc = driver.getCurrent();
		int nextMove = driver.getNext();
		if ((loc == 0 && nextMove == 4) || (loc == 4 && nextMove == 0)){
			return "Meow Street";
		}
		if ((loc == 1 && nextMove == 5) || (loc == 5 && nextMove == 1)){
			return "Chirp Street";
		}
		if (loc<3 && nextMove <3){
			return "Fourth Avenue";
		}
		return "Fifth Avenue";
	}
	
	public static int nextMove(int rand,Driver driv,int turn){
		int loc = driv.getCurrent();
		if (turn == 0){
			if(loc == 2){ //handles outside city start 1
				return 0;
			}
			if(loc == 3){ //handles outside city start 2
				return 5;
			}
		}
		if (loc == 0 || loc == 1){
			if(rand == 0){
				loc++;
			}
			else{
				loc+=4;
			}
			return loc;
		}
		if (loc == 4 || loc == 5){
			if(rand == 0){
				loc--;
			}
			else{
				loc-=4;
			}
			return loc;
		}
		
		return -1; //error case
	}
}
