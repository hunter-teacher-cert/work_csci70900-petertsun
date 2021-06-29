/**
 * Converts temperature from Celsius to Fahrenheit
 */

import java.util.Scanner;


public class ConvertC2F {

	public static void main(String[] args) {
		double celsius, fahrenheit;
		final double slope = 9/5;
		final double fIntercept = 32.0;
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter temperature in degree celsius: ");
		celsius = in.nextInt();

		fahrenheit = slope * celsius + fIntercept;

		System.out.printf("%.2f C = %.2f F\n", celsius, fahrenheit);














	}











}
