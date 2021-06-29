
/*
 * 4. You cannot use enhanced for loop because you need access to the index which the enhaced
 *    for loop hides.
 */


import java.io.*;
import java.util.*;

public class Arrays {


	public static double[] powArray(double[] a, int n) {
		double[] b = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = Math.pow(a[i], n);
		}
		return b;

	}


	public static void printArray(double[] a) {
		System.out.print("{" + a[0]);
		for (int i = 1; i < a.length; i++) {
			System.out.print(", " + a[i]);
		}
		System.out.println("}");
	
	}

	public static void printIntArray(int[] a) {
		System.out.print("{" + a[0]);
		for (int i = 1; i < a.length; i++) {
			System.out.print(", " + a[i]);
		}
		System.out.println("}");
	}

	public static void printBooleanArray(boolean[] a) {
		System.out.print("{" + a[0]);
		for (int i = 1; i < a.length; i++) {
			System.out.print(", " + a[i]);
		}
		System.out.println("}");
	}

	public static double[] randomArray(int size) {

		Random random = new Random();
		double[] a = new double[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextDouble();

		}
		return a;

	}

	public static int[] randomIntArray(int size) {
		Random random = new Random();
		int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(100);
		}
		return a;
	}

	public static int[] histogram(int[] scores, int numCounters) {
		int[] counts = new int[numCounters];
		for (int i = 0; i < scores.length; i++) {
			int index = scores[i];
			counts[index]++;

		}
		return counts;


	}

	public static int indexOfMax(int[] values) {
		int indexMax = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] > values[indexMax]) {
				indexMax = i;

			} // else do nothing

		}
		return indexMax;

	}

	public static boolean[] sieve(int n) {
		int[] values = new int[n];
		boolean[] primes = new boolean[n];
		int p = 2;

		int compositeIndex = 0;
		int index = 0;
		boolean haveSmallestPrime = false;

		for (int i = 0; i < n; i++) {
			values[i] = i;
		}

		for (int i = 0; i < n; i++) {
			primes[i] = true;
		}

		//0 is not a prime number
		primes[0] = false;
		// 1 is not a prime number
		primes[1] = false;

		if (n > 2) {

		// 2 is a prime - the smallest prime
		primes[p] = true;
		compositeIndex = p + p;
		while (compositeIndex < n) {
			primes[compositeIndex] = false;
			compositeIndex = compositeIndex + p;
		}

		index = p + 1;
		for (int i = index; i < n; i++) {

			if (primes[i] == true && haveSmallestPrime == false){
				p = i;
				haveSmallestPrime = true;

			}
		}
		while (haveSmallestPrime){
			haveSmallestPrime = false;
			compositeIndex = p + p;
			while (compositeIndex < n){
				primes[compositeIndex] = false;
				compositeIndex = compositeIndex + p;
			}
			index = p + 1;
			for (int i = index; i < n; i++) {
				if (primes[i] == true && haveSmallestPrime == false) {
					p = i;
					haveSmallestPrime = true;
				}
			}
		}


		}

		//printIntArray(values);
		//printBooleanArray(primes);

		return primes;


	}

	public static void main(String[] args) {
		int[] testScores = randomIntArray(17);
		int n4FindingPrimes;


		Scanner in = new Scanner(System.in);


		System.out.print("This program will find primes up to a number. Enter the number: ");
		n4FindingPrimes = in.nextInt();

		printBooleanArray(sieve(n4FindingPrimes));


		/*
		printIntArray(testScores);
		System.out.println(indexOfMax(testScores));
*/


		/*
		printIntArray(testScores);
		printIntArray(histogram(testScores, 100));
*/

	}

}
