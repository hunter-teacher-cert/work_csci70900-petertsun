# Aim: How do we show iteration?
## Objectives:
 * Determine the initialization and test condition for iteration
 * Explain that the iteration continues until the test condition is false
 * Choose the appropriate update step

## NYS COMPUTER SCIENCE AND DIGITAL FLUENCY LEARNING STANDARDS
  * **K-1.CT.8** Identify a task consisting of steps that are repeated, and
    recognize which steps are repeated.
  * **2-3.CT.8** Identify steps within a task that should only be
    carried out under certain precise conditions.
  * **4-6.CT.8** Develop algorithms or programs that use repetition and
    conditionals for creative expression or to solve a problem.

## Standards:
 * **1. B** Determine code that would be used to complete code segments.
 * **2. B** Determine the result or output based on statement execution order
      in a code segment without method calls (other than output).
 * **3. C** Write program code to satisfy method specifications using
  expressions, conditional statements, and iterative statements.

## Warm Up:  
Time: 5 minutes  
Teacher gives students suggestions for dancing with their arms, like
raising arm, putting down arm, etc. Students pair with a neighbor and
give a suggestion to the neighbor about how to move their arms.
 * Teacher checks with the whole classes on some possible dance moves with
   their arms

## Introduction:  
Time: 5 minutes  
Teacher makes a list of dance moves with their arms and collaborates with students to come up with names for those dance moves. Teacher introduces an example of while loop. A while loop has a test condition to determine whether to perform the instructions inside the while loop block. To make the test condition useful, there needs to be an initialization of a variable used in the test condition. Inside the while block, this variable needs to be updated for the test to fail. The loop instruction will be carried out if the test condition is evaluated to be true. When the test condition is evaluated to be false, the computer will exit the loop without performing any instruction.

## Lesson Content:  
Time: 10 minutes  
Say you did something your teacher did not like. The teacher punished you
by requiring you to write "I will not do this ever again" 20 times.
However, you don't want to write that, yet you don't want to rebel against your teacher. Why not ask the computer to write it for you?
You can asked the computer to print out a sentence. How do we ask
the computer to do it repeatedly?
`System.out.println("I will not do this ever again. ");`


```
int count = 0;
while (count < 20) {
  System.out.println("I will not do this ever again.");
  count = count + 1;
}
```

In this code, count is initialized to 0. The 0 value is associated to count.
The while loop checks if count is less than 20. Yes it is, the while
loop goes ahead and performs the while loop block's instructions:
printout is performed, and count is increased by 1. This keeps continuing
until count is 19. The while loop checks if 19 is less than 20. Yes it is.
The loop carries out the while loop's block of instructions. So far,
the punishment sentences were written 20 times (count 0 to 19, that is 20 times). After the latest update, count = 20. The while loop checks if count is less than 20. No, 20 is not less than 20. The test condition is evaluated to be false. The computer exits the while loop.

## Lesson Activity  
Time: 15 minutes  
Instead of writing a code at a terminal. Let's use our bodies as computers.
Teacher acts as student A who writes a while loop to give instruction for student B to carry out.

```
int count = 0;
while (count < 2) {
  Raise left arm;
  Raise right arm;
  Put down right arm;
  Put down left arm;
  count = count + 1;
}
```
Then, teacher act out student B. Follow the direction. keep track of count. Before the loop, count is 0. test is passed. boolean expression is evaluated to be true, raise left, then right arm, put down right, then left arm. Update the count to 1. 1 is less than 2, do the whole dance routine again. Now, count becomes 2. When student B (as a computer) checks 2 < 2, the test fails because the boolean expression is evaluated to be false, student B exits the loop.
 * Teacher asks students analog feedback on if they know what to do.

Students take turn to be A and B. Student A writes a while loop that asks the dancer to repeat dance routine for a number of times. Student B reads the while loop instruction and carries out the dance moves according to the written instruction.

## Closing  
Time: 10 minutes  
Students can demonstrate their dance moves based on written instruction in the form of pseudocode. As they perform their dance moves, they verbalize or have someone else narrate their movements according to the while loop commands.
 * Teacher asks students analog feedback on if they can read while loop
 * Teacher asks students analog feedback on if they can implement while loop

## Feedback  
Time: 0 minutes - Homework  
 Teacher asks students to evaluate if the dance moves help them
 understand while loop. Students can give feedback by ranking the activity and instruction from 1 to 10 with 10 being the best. Students can also give a brief written or verbal feedback on what parts of the lesson works or does not work for them.
