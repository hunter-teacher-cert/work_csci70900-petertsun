import java.io.*;
import java.util.*;

public class Craps {


	public static int roll(int maxNum) {
	
		Random random = new Random();
		// random.nextInt(10) returns a random number between 0 and up to including 9
		return random.nextInt(maxNum) + 1;
	
	}

	public static int shoot(int numDice, int maxValueForOneDice) {

		int sum = 0;
		for (int i = 0; i < numDice; i++) {
			sum = sum + roll(maxValueForOneDice);

		}
		return sum;

	}

	// return true when win, return false when lose
	public static boolean round() {
		int result;
		int point;

		result = shoot(2, 6);
		if (result == 2 || result == 3 || result == 12) {
			return false;
		} else if (result == 7 || result == 11) {
			return true;
		} else {
			point = result;
			result = shoot(2, 6);
			if (point == result) {
				return true;
			} else if (point == 7) {
				return false;
			} else {
				while ((point != result) && (point != 7)){
					result = shoot(2, 6);
				}
				if (point == result) {
					return true;
				} else {  // point == 7
					return false;
				}
			}
		}
	}






	public static void main(String[] args) {
		int n;
		Scanner in = new Scanner(System.in);

		System.out.print("Enter the number of times you want to play craps: ");
		n = in.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(round());
		}



	}






}
