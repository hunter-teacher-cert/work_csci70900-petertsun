/*
 * Chris O'Brien, Eduardo Leite, Peter Tsun
 */

// This is a computer version of a game called Mancala

import java.io.*;
import java.util.*;

/*
TODO:
implement turn for player 1
*/

public class Mancala {
//  checks if p1-p6 or p7-p12 is empty;
  //Two global varibles
  public static int lastState = 6;
  public static boolean player1LastPlayer = true;

  public static int sumS(int[] pits){
    //adds up the seeds in an array.
    int mySum = 0;
    for (int pit : pits){
      mySum += pit;
    }
    return mySum;
  }

  public static Boolean isGameOver(int[] gameBoard){
    Boolean gameOver = false;
    // create slice for p1:p6
    int[] player1Slice = getSliceOfArray( gameBoard, 0, 5);
    //create slice for p7:p12
    int[] player2Slice = getSliceOfArray( gameBoard, 7, 12);
    int player1NumSeeds = sumS(player1Slice);
    int player2NumSeeds = sumS(player2Slice);

    if ( (player1NumSeeds == 0) || (player2NumSeeds == 0) ) {
      gameOver = true;
    } else {
      gameOver = false;
    }

    return gameOver;
  }

  public static int[] getSliceOfArray(int[] wholeArray, int startIndex, int endIndex) {

    int[] slice = new int[endIndex - startIndex + 1];
    int i;

    for (i = 0; i < slice.length; i++) {
      slice[i] = wholeArray[startIndex + i];
    }
    return slice;
  }


  public static int[] startBoard(int[] gameBoard) {
    for (int i = 0; i< gameBoard.length; i++){
      if (i == 6 || i == 13){
        continue;
      } else {
          gameBoard[i] = 4;
      }
    }
    return gameBoard;
  }

  public static int[] playerOneTurn(int[] gameBoard){
    //Player one can pick p1-p6. Then the n seeds in the p are sown in the next n places.
    Scanner in = new Scanner(System.in);
    int modI = 0;
    displayBoard(gameBoard);
    System.out.print("Player 1. Which pit (0, 1, 2, 3, 4, 5) do you choose?");
    int choice = in.nextInt();
    while (choice < 0 || choice > 5) {
      System.out.print("Player 1. Which pit (0, 1, 2, 3, 4, 5) do you choose?");
      choice = in.nextInt();
    }
    int numSeeds = gameBoard[choice];
    gameBoard[choice] = 0;
    int stopIndex = choice + numSeeds + 1;
    for (int i = choice + 1; i < stopIndex; i++) {
      modI = i %14;
      if (modI == 13) { // skip player 2's mancala
        //skip opponents mancala
        stopIndex = stopIndex + 1;
      } else {
        //place seed in pit/ player 1's mancala
      gameBoard[modI] = gameBoard[modI] + 1;

      }

    }
    lastState = modI;
    // When the last stone dropped is into an empty pit on your side,
    // you capture the stones in the opposite pit (store in mancala)
    if (lastState >= 0 && lastState < 6 && gameBoard[lastState] == 1) {
      gameBoard[6] = gameBoard[6] + gameBoard[12 - lastState]; //Opposite pit has an index of (12 - lastState)
      gameBoard[12 - lastState] = 0;
    }


    return gameBoard;
  }



  public static int[] playerTwoTurn(int[] gameBoard){
    //Player two can pick p1-p6. Then the n seeds in the p are sown in the next n places.
    Scanner in = new Scanner(System.in);
    int modI = 0;
    displayBoard(gameBoard);
    System.out.print("Player 2. Which pit (7, 8, 9, 10, 11, 12) do you choose?");
    int choice = in.nextInt();
    while (choice < 7 || choice > 12) {
      System.out.print("Player 2. Which pit (7, 8, 9, 10, 11, 12) do you choose?");
      choice = in.nextInt();
    }
    int numSeeds = gameBoard[choice];
    gameBoard[choice] = 0;
    int stopIndex = choice + numSeeds + 1;
    for (int i = choice + 1; i < stopIndex; i++) {  // skip player 1's mancala
      modI = i %14;
      if (modI == 6) {
        //skip opponents mancala
        stopIndex = stopIndex + 1;
      } else {
        //place seed in pit/ player 1's mancala
      gameBoard[modI] = gameBoard[modI] + 1;

      }

    }
    lastState = modI;
    // When the last stone dropped is into an empty pit on your side,
    // you capture the stones in the opposite pit (store in mancala)
    if (lastState > 6 && lastState < 13 && gameBoard[lastState] == 1) {
      gameBoard[13] = gameBoard[13] + gameBoard[12 - lastState]; //Opposite pit has an index of (12 - lastState)
      gameBoard[12 - lastState] = 0;
    }

    return gameBoard;


  }

  public static void displayBoard(int[] gameBoard){
    //Displays
    System.out.println("Current board: ");
    System.out.println("[Player 1's pits & Mancala; Player 2's pits, and Mancala ]");
    System.out.println("[1, 2, 3, 4, 5, 6, M1; 7, 8, 9, 10, 11, 12, M2]");
    System.out.println(Arrays.toString(gameBoard));

  }

  public static Boolean playerOneWin(int[] gameBoard) {
    if ( gameBoard[6] > gameBoard[13] ) {
      return true;
    } else {
      return false;
    }
  }

  public static Boolean playerTwoWin(int[] gameBoard) {
    if ( gameBoard[13] > gameBoard[6] ) {
      return true;
    } else {
      return false;
    }
  }




  public static void main(String[] args) {
    /* create a gameBoard array,
    0-5: player one's pits, total of 6 (p1-p6)
    6: player 1's Mancala (M1)
    7-12: player two's pits, total of 6 (p7-p12)
    13: player two's Mancala (M2)
    */
    int[] gameBoard;
    gameBoard = new int[14];
    gameBoard = startBoard(gameBoard);

    while (!isGameOver(gameBoard)) {

      if ((lastState == 6 && player1LastPlayer) ||
          (lastState != 13 && !player1LastPlayer)) {
      gameBoard = playerOneTurn(gameBoard);
        if (isGameOver(gameBoard)) {
          if (playerOneWin(gameBoard)) {
            System.out.println("PLayer 1 wins!");
          } else {
            System.out.println("Player 2 wins!");
          }
          break;
        } else {
          System.out.println();
        }
        player1LastPlayer = true;
      } else if  ((lastState == 13 && !player1LastPlayer) ||
                   (lastState != 6 && player1LastPlayer)) {

        gameBoard = playerTwoTurn(gameBoard);
        if (isGameOver(gameBoard)) {
          if (playerTwoWin(gameBoard)) {
            System.out.println("PLayer 2 wins");
          } else {
            System.out.println("Player 1 wins");
          }
          break;
        } else {
          System.out.println();
        }
        player1LastPlayer = false;
      }

    }

    displayBoard(gameBoard);

  }
}
