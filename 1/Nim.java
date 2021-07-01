
/*
 * Eric Liu, Jiyoon Kim, Liam Baum, Peter Tsun
 */

import java.io.*;
import java.util.*;

public class Nim {


	//Check if the game is over
	public static boolean gameOver( int numberStones) {

		if (numberStones == 0) {
			return true;
		} else {
			return false;
		}

	}

	//responsible for obtaining the correct number of rocks to be removed from the bag
	public static int userNumStonesRemoved() {
		Scanner in = new Scanner(System.in);
		int NumStonesRemoved;
		final int maxNumStonesRemoved = 3;
		final int minNumStonesRemoved = 1;

		System.out.print("Enter the number of Stones you want to remove from the bag: ");
		NumStonesRemoved = in.nextInt();

		while (NumStonesRemoved < minNumStonesRemoved || NumStonesRemoved > maxNumStonesRemoved) {

			System.out.print("Enter the number of Stones you want to remove from the bag (1, 2, or 3 only): ");
			NumStonesRemoved = in.nextInt();

		}
		return NumStonesRemoved;

	}

	// computer generates a integer number from 1 to 3 
	public static int aiNumStonesRemoved() {
		Random aiNumStones = new Random();
		int numStonesRemoved = aiNumStones.nextInt(3) + 1;

		return numStonesRemoved;
	}



	//the printing of numbers of rocks removed and number of rocks remained are done in main()
	//the main loop keeps getting inputs from user or computer until game is over
	public static void main(String[] args) {

		int numStones = 12;
		Random aiNumStones = new Random();
		int numStoneRemoved = 0;

		while (gameOver(numStones) == false) {

			numStoneRemoved = userNumStonesRemoved();
			while ( numStoneRemoved > numStones ) {                       // Check that there is enough rocks
				System.out.println("There is not that many stones.");
				numStoneRemoved = userNumStonesRemoved();
			}
			numStones = numStones - numStoneRemoved;
			if ( gameOver(numStones) ) { // if no more rocks, you win. Make a printout. Exit main loop

				System.out.println("You win");
				System.out.println("The number of stones you removed from the bag is " + numStoneRemoved);
				System.out.println("The number of stones in the bag is " + numStones );
				break;

			} else { // o.w. just print out. computer's turn is next

				System.out.println("The number of stones you removed from the bag is " + numStoneRemoved);
				System.out.println("The number of stones in the bag is " + numStones );

			}
			numStoneRemoved = aiNumStonesRemoved();
			if ( numStoneRemoved > numStones && numStones < 4) {           // if no more than 3 rocks & not enough rocks
				numStoneRemoved = aiNumStones.nextInt(numStones) + 1;  // pick a number from 1 to numStones
			}
			numStones = numStones - numStoneRemoved; // subtract knowing there are enough stones
			if ( gameOver(numStones)) {  //if no more stones, the computer wins. print out. exit main loop
				System.out.println("AI win");
				System.out.println("The number of stones AI removed from the bag is " + numStoneRemoved);
				System.out.println("The number of stones in the bag is " + numStones );
				break;
			} else {          // print out status. user's turn is next.

				System.out.println("The number of stones AI removed from the bag is " + numStoneRemoved);
				System.out.println("The number of stones in the bag is " + numStones );
			}



		}



	}

}


// data: number of stones  in a bag
// max number of stones tha can be removed at one time = 3
//
// method: prompt user for the number of stones to be removed
// - tell user how many stones AI removed and how many remains
// announces who wins
