import java.io.*;
import java.util.*;

public class BarGraph{

  char[][] graph;
  int[] values;
  int rows;
  int cols;

  public BarGraph(int[] nums) {
    int m = max(nums);
    values = new int[nums.length];
    int i = 0;
    int row;
    int col;

    graph = new char[m][nums.length];

    int rows = graph.length;
    int cols = graph[0].length;

    //This is for the display of numbers below bar graph
    for (i = 0; i < values.length; i++){
      values[i] = nums[i];
    }
    // Assign a blank space to each item in the 2D array
    for ( i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++){
        graph[i][j] = ' ';
      }
    }

    // Fill the graph with bars
    for (col = 0; col < cols; col++ ){
      for (row = rows -1 ; row > rows - 1 - values[col]; row-- ){
        graph[row][col] = '*';
      }
    }


  }


  // find max integer in an array
  public static int max(int[] nums){
    int m = nums[0];
    for (int i = 0; i < nums.length; i++){
      if (nums[i] > m){
        m = nums[i];
      }
    }
    return m;
  }

  //get the 2D array ready to be printed
  public String toString(){
    int row,col;
    rows = graph.length;
    cols = graph[0].length;

    String result = "";
    for (row = 0; row < rows; row++){
      for (col = 0; col < cols; col++){
        result = result + "   " + graph[row][col];
      }
      result = result +"\n";
    }
    for ( col = 0; col < cols; col++){
      result = result + String.format("%4d", values[col]);
    }
    result = result + "\n";

    return result;
  }



}
