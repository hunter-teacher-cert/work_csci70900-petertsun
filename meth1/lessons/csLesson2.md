# Aim: How do we trace recursion?
## Objectives
 * Identify the base case of recursion
 * Evaluate what the program does after a return from a recursion call
 * Cite evidence from the code to show how the program makes recursive calls

## NYS COMPUTER SCIENCE AND DIGITAL FLUENCY LEARNING STANDARDS
 * **K-1.CT.8** Identify a task consisting of steps that are repeated, and
   recognize which steps are repeated.
 * **2-3.CT.8** Identify steps within a task that should only be
   carried out under certain precise conditions.
 * **4-6.CT.8** Develop algorithms or programs that use repetition and
   conditionals for creative expression or to solve a problem.

## AP Standards
 * **1. B** Determine code that would be used to complete code segments.
 * **2. D** Determine the number of times a code segment will execute.
 * **5. A** Describe the behavior of a given segment of program code.

## Warm Up
Time: 5 minutes  
Teacher asks students to draw a picture of a function. Let's say the function is
x squared ( x<sup>2</sup> ). After they draw their pictures, students show their
diagrams to their classmates in their groups, and talk about
how the diagram represents a computer program method.
 * Teacher checks in with students on how they represent a function/method with a diagram.

## Lesson Content
Time: 20 minutes  
Recursion is unique from other programming techniques that we learned. In recursion,
a function calls on itself to do things. It may seem like the recursion call will
result in an unending loop, but it is possible to use recursion to accomplish
useful tasks without the program getting hung up in an infinite loop.

For recursion to work correctly, there needs to be a base case. The base case is
where the repeated call to itself stops. In recursion, a function calls itself
to perform work on a smaller problems. When the function calls on itself to do
work on a smaller value, we trust that the function call to itself will return
the correct result. In the function, appropriate action is taken to use the result
from the recursive call that returns. To better understand this, let's look at a
concrete example.

Let's say you want to add numbers 1 through 10, which a for loop can quickly tell
us that the answer is 55. This example is really to help you learn recursion, not
to showcase how it can be super useful. The recursion code looks like this:

// base case sum(1) gives 1,  sum(1) = 1  
// recursive call. To find sum(10), we will rely on sum(9) being calculated correctly  
// When we need to find sum(10), the function sum will make a call to sum(9) which  
// is supposed to return sum from 1 to 9  
// When the sum(9) returns the correct answer (45), the sum(10) will add 10 to sum(9)  
// so that the sum(10) = 10 + sum(9)  

```
public static int sum(int n) {
  if (n == 1) { // when asked to calculate sum(1), the result is 1.
    return 1;
  }

  int sum = n + sum(n-1); // this is a generalized case of sum(10) = 10 + sum(9)

  return sum;

}
```

To understand this recursion process, one can draw trace diagram:  
[sum(10)] --> [sum(9)] --> [sum(8)]  --> [sum(7)] --> [sum(6)] --> [sum(5)] -->
[sum(4)] --> [sum(3)]  --> [sum(2)] --> [sum(1)]
At 1, sum() return 1 to prev function call which you can think of as a person
[sum(2)] returns 3 == 2 + 1 to [sum(3)], which in turn returns 6 == 3 + 3 to
[sum(4)] which returns 4 + 6 ==10 to [sum(5)], which returns 5 + 10 == 15 to
[sum(6)] which returns 6 + 15 == 21 to [sum(7)] which returns 7 + 21 == 28 to
[sum(8)] which returns 8 + 28 == 36 to [sum(9)] which finally returns 9 + 36 == 45
to the original calling function [sum(10)] which produces the final result of 10 + 45 == 55.
 * Check in with students to get analog feedback to see how many students feel they understand recursion.

## Lesson Activity  
Time: 15 minutes  

Before students talk out the flow of the program and trace the program with diagrams,
teacher checks with students on the base case (the case where there is no more
calling itself), the recursive call when trying to find factorial(n), and what
the method/function does with the result from the recursive call that just returns.
In this case, the base case is when factorial(1) == 1; when finding factorial(n),
the code inside this method makes a recursive call to factorial(n-1);  
when factorial(n -1) returns to the calling function factorial(n), the method
multiplies n to factorial(n -1), and returns the result of n * factorial (n - 1).
```
public static int factorial(int n) {
  if (n == 1 || n == 0) { // when asked to calculate 1! or 0!, the result is 1.
    return 1;
  }

  int product = n * factorial(n-1); // this technique asks that you trust that
                         // factorial(n-1) returns the correct result of (n-1)!

  return product;

}
```
Teacher demonstrates with a small group:  
Time: 10 minutes  
Students work with a reasonable example of factorial(3). Student A calculates
factorial(3) by looking at the code. 3 not = 1 or 0, just calculate the
result 3 * factorial(2). Student A passes the work to student B to find
factorial(2). Reading the same script of instruction, 2 not = 1 or 0, skip to
mulitplying 2 by factorial(1). Student B passes the work to Student C.
Student gets the request factorial(1). Yes the parameter n == 1, and 1 == 1.
Carry out the instruction in the if block. return 1 to the calling function
which is student B. The rest of the program is skipped because the program exits to return inside the if block before the program has a chance to carry out the rest
of the instructions in the method of factorial(n). Student B multiplies 2 to 1, and returns result of 2 to Student A, who in turns multiplies 3 to 2, and returns the final answer of 6.

Students work in their group to calculate a slightly larger n, like factorial(4).
Each student acts as a copy of the method factorial(n).

## Closing  
Time: 5 minutes  
Students or teacher included can act out how a factorial(n) can calculate n!
The size of n depends on the amount of time left. The less time remaining the smaller the n for the closing example.
 * Check in with students by using analog feedback to describe how well they can
   explain recursion example of factorial.   
