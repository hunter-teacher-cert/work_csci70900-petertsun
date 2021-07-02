
// Brian Mueller, Emma Wingreen, Peter Tsun

import java.io.*;
import java.util.*;

/**
   The Rules of Life:
   Survivals:
   * A cell with 2 or 3 living neighbours will survive for the next generation.
   Death:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.
   Birth:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation
*/

public class Cgol
{

  //initialize empty board (all cells dead)
  public static char[][] createNewBoard(int rows, int cols) {
    //Initialize a new array of characters
    char[][] a = new char[rows][cols];

    //Use a foreach loop to initialize the empty board
    // for(char[] row: a){
    //   for(char element: row){
    //     element = 'a';
    //   }
    // }
    for(int i = 0; i < a.length; i++){
        for(int j = 0; j < a[i].length; j++){
            a[i][j] = '-';
        }
    }

    return a;
  }


  //print the board to the terminal
  public static void printBoard(char[][] board) {
    for(int row = 0; row < board.length; row++) {
      for (int cell = 0; cell < board[row].length; cell++){
        System.out.print(board[row][cell] + " ");
      }
      System.out.println();
    }
  }


  //set cell (r,c) to val
  public static void setCell(char[][] board, int r, int c, char val){
    board[r][c] = val;
  }


  //return number of living neigbours of board[r][c]
  public static int countNeighbours(char[][] board, int r, int c) {

    int rmin = r - 1;
    int rmax = r + 1;
    int cmin = c - 1;
    int cmax = c + 1;

    int numNeighbors = 0;
    if (c == 0) {
      cmin = 0;
    } else if (c == board[r].length - 1) {
      cmax = c;
    }

    if (r == 0) {
      rmin = 0;
    } else if (r == board.length - 1) {
      rmax = r;
    }
    int numRow = rmax - rmin + 1;
    int numCell = cmax - cmin + 1;
    int stopRow = rmin + numRow;
    int stopCell = cmin + numCell;
    for (int row = rmin; row < stopRow; row++ ) {
      for (int cell = cmin; cell < stopCell; cell++ ){
        if (board[row][cell] == 'X') {
          numNeighbors = numNeighbors + 1;
        }
      }
    }
    if (board[r][c] == 'X') {
      numNeighbors = numNeighbors - 1;
    }

    return numNeighbors;
  }


  /**
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'X', dead ' ')
  */
  public static char getNextGenCell(char[][] board,int r, int c) {
    int numberOfLivingNeighbors = 0;

    numberOfLivingNeighbors = countNeighbours(board, r, c);
    if (board[r][c] == 'X') {
      if ( numberOfLivingNeighbors < 2 || numberOfLivingNeighbors > 3 ) {
        return '-';
      } else {
        return 'X';
      }
    } else { // cell is dead
      if ( numberOfLivingNeighbors == 3 ) {
        return 'X';
      } else {
        return '-';
      }
    }


  }


  //generate new board representing next generation
  public static char[][] generateNextBoard(char[][] board) {
    char[][] nextBoard = new char[board.length][board[0].length];
    for (int row = 0; row < board.length; row ++) {
      for (int cell = 0; cell <board[0].length; cell++) {
        // nextBoard[row][cell] = getNextGenCell(board, row, cell);
        setCell(nextBoard, row, cell, getNextGenCell(board, row, cell));
      }
    }
    return nextBoard;
  }


  public static void main( String[] args )
  {
    int x = 0;
    Scanner in = new Scanner(System.in);
    int row = 0;
    int column = 0;
    char play ='p';

    char[][] board;
    board = createNewBoard(7,7);

    //breathe life into some cells:
    setCell(board, 0, 0, 'X');
    setCell(board, 0, 1, 'X');
    setCell(board, 0, 2, 'X');
    setCell(board, 1, 0, 'X');
    setCell(board, 1, 1, 'X');
    setCell(board, 1, 2, 'X');
    setCell(board, 2, 0, 'X');
    setCell(board, 2, 1, 'X');
    setCell(board, 2, 2, 'X');
    setCell(board, 5, 5, 'X');
    setCell(board, 5, 6, 'X');
    setCell(board, 6, 5, 'X');
    setCell(board, 6, 6, 'X');

    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)
    System.out.println("Generation: " + x );
    printBoard(board);
    System.out.println("--------------------------\n\n");


    while(play != 'q') {


      while (play != 'p') {
        System.out.print("Enter row ");
        row =in.nextInt();
        System.out.print("Enter cell");
        column =in.nextInt();
        setCell(board, row, column, 'X');
        printBoard(board);
        System.out.println("--------------------------\n\n");
        System.out.println("Enter p to play or x to make a living cell");
        play = in.next().charAt(0);

      }

      board = generateNextBoard(board);
      x++ ;
      System.out.println("Generation: " + x);
      printBoard(board);
      System.out.println("--------------------------\n\n");

      System.out.println("Enter p to play or x to make a living cell or q to exit soon");
      play = in.next().charAt(0);
    }


    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class
