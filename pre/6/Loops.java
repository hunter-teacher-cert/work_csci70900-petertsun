
/*
 * #4. n = 9 for x = 1 and digits match.
 * #5 accuracy is better when the x value is smaller.
 * #6 again accuracy is better when x value is smaller
 */


import java.io.*;
import java.util.*;

public class Loops {

	public static double power(double x, int n) {
		int count = 0;
		double product = 1;

		while ( count < n) {
			product = product * x;
			count++;
		}
		return product;
	}

	public static double factorial(int n) {
		int count;
		double product = 1;


		for(count = 1; count <= n; count++) {
			product = product * count;


		}
		return product;

	}


	public static double myexp(double x, int n) {
		int count;
		double sum = 0;

		for (count = 0; count <= n; count++) {
			sum = sum + power(x,count) / factorial(count);

		}
		return sum;

	}

	public static double myexp2(double x, int n) {
		double numerator = 1.0;
		int denominator = 1;
		double sum = numerator / denominator;
		int count;

		for(count = 1; count <= n; count++) {
			numerator = numerator * x;
			denominator = denominator * count;
			sum = sum + numerator/denominator;

		}
		return sum;

	}

	public static void check(double x, int n) {

		System.out.printf("%f \t %f \t %f \n", x, myexp(x, n), Math.exp(x));


	}


	public static void main(String[] args) {
		
		double x;
		int n;
		Scanner in = new Scanner(System.in);
		int count;
		double xValue = -0.1;
//		double xValue = 0.1;
/*
		for (count = 1; count < 5; count++) {
			check(xValue, 9);
			xValue = 10* xValue;

		}
*/


/*
		for (count = 1; count < 5; count++) {
			check(xValue, 9);
			xValue = 10 * xValue;


		}
*/


/*
		System.out.print("Enter x: ");
		x = in.nextDouble();
		System.out.print("Enter n: ");
		n = in.nextInt();
		System.out.println(myexp(x, n));
		System.out.println(myexp2(x, n));
		check(x, n);
*/


		System.out.print("To calculate n!, Enter the number n: ");
		n = in.nextInt();
		System.out.print(factorial(n));


/*
		System.out.print("Enter the base: ");
		x = in.nextDouble();
		System.out.print("Enter the exponent: ");
		n = in.nextInt();
		System.out.print(power(x, n));
*/





	}


}
