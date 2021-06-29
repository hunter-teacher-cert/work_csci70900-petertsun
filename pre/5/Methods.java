
/*
 * https://hackernoon.com/calculating-the-square-root-of-a-number-using-the-newton-raphson-method-a-how-to-guide-yr4e32zo
 */

import java.io.*;
import java.util.*;

public class Methods {



	public static boolean isDivisible(int dividend, int divisor) {

		if ( dividend % divisor == 0 ) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isTriangle(double lengthA, double lengthB, double lengthC) {

		if (lengthA >= (lengthB + lengthC)) {
			return false;
		} else if (lengthB >= (lengthA + lengthC) ) {
			return false;
		} else if (lengthC >= (lengthA + lengthB) ) {
			return false;
		} else {
			return true;
		}

	}


	public static int ack(int m, int n) {
		int result = 0;

		if ( (m > 0) && (n > 0) ) {
			result = ack(m - 1 , ack(m, n - 1));
		} else if ((m > 0) && (n == 0)) {
			result = ack(m - 1, 1);
		} else if (m == 0) {
			result = n + 1;
		}
		return result;
	}



	public static double approximateTheSquareRoot(double guess, double radicand){
		return (guess + radicand / guess) / 2;

	
	}

	public static double raiseToThePower(double base, int exponent) {
		double product = 1.0;
		int count = 0;

		if (exponent != 0) {
			while (count < exponent){
				product = product * base;
				count++;
			}
		} else {
			product = 1;
		}

		return product;

	}


	public static int homeMadeFactorial(int number) {


		int count;
		int product = 1;

		if (number != 0) {
			for (count = 1; count <= number; count++) {
				product = product * count;
			}
		} else {
			product = 1;
		}

		return product;

	}


	public static double eToNegXsquared(double x, int n) {
		int count = n - 1;
		double sum = 0;

		for (count = 0; count < n; count++) {
			sum = sum + raiseToThePower(-1.0, count) * raiseToThePower(x, 2*count) / homeMadeFactorial(count);

		}

		return sum;

	}


	public static int frequency(String setOfCharacters, char alphabet) {
		int count = 0;
		int index;
		int length = setOfCharacters.length();

		for (index = 0; index < length; index++) {
			if (alphabet == setOfCharacters.charAt(index)) {
				count++;
			}

		}

		return count;


	}

	public static boolean canSpell(String setOfTiles, String word) {

		return false;

	}


	public static void main(String[] args) {

		double radicand;
		double guess;
		double refinedGuess;
		double threshold = 0.0001;
		int dividend;
		int divisor;
		double a, b, c;
		int m, n;

		Scanner in = new Scanner(System.in);

		System.out.print("Enter m: ");
		m = in.nextInt();
		System.out.print("Enter n: ");
		n = in.nextInt();
		System.out.printf("ack( %d ,  %d ) = %d", m, n, ack(m,n));

/*
		System.out.print("Enter length A of a triangle: ");
		a = in.nextDouble();
		System.out.print("Enter length B of a triangle: ");
		b = in.nextDouble();
		System.out.print("Enter length C of a triangle: ");
		c = in.nextDouble();
		if (isTriangle(a, b, c)) {
			System.out.println("It can be a triangle.");
		} else {
			System.out.println("It cannot be a triangle.");

		}

*/

/*
		System.out.print("Enter a number that you want to be divided: ");
		dividend = in.nextInt();
		System.out.print("Enter a number that will be used to divide the numerator: ");
		divisor = in.nextInt();
		if (isDivisible(dividend, divisor)) {
			System.out.printf("%d is divisible by %d", dividend, divisor); 

		} else {
			System.out.printf("%d is not divisible by %d", dividend, divisor);
		}
*/
				
		/*

		System.out.print("Enter a number that you want to find its sqaure root: ");
		radicand = in.nextDouble();
		guess = radicand / 2;
		refinedGuess = approximateTheSquareRoot(guess, radicand);
		while ( Math.abs(guess - refinedGuess) > threshold) {
			guess = refinedGuess;
			refinedGuess = approximateTheSquareRoot(refinedGuess, radicand);

		}



		 System.out.printf("%.2f has a square root of %.2f\n", radicand, refinedGuess);
		 System.out.println(eToNegXsquared(0.5, 3));

		 System.out.println(frequency("banana", 'a'));

		
				System.out.print(raiseToThePower(-1.0, 9));
		*/






	}



}

