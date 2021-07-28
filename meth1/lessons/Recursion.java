


public class Recursion {

  public static int sum(int n) {
    if (n == 1) { // when asked to calculate sum(1), the result is 1.
      return 1;
    }

    int sum = n + sum(n-1); // this is a generalized case of sum(10) = 10 + sum(9)

    return sum;

  }

  public static int factorial(int n) {
    if (n == 1 || n == 0) { // when asked to calculate 1! or 0!, the result is 1.
      return 1;
    }

    int product = n * factorial(n-1); // this technique asks that you trust that
                           // factorial(n-1) returns the correct result of (n-1)!

    return product;

  }

  public static void main(String[] args) {

    System.out.println("The sum from 1 to 6 is " + sum(6));
    System.out.println("The factorial of 9 is " + factorial(9));



  }
}
