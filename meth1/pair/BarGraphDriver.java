import java.io.*;
import java.util.*;

public class BarGraphDriver{

  public static void main(String[] args) {
    int[] test = new int[]{1,2,3,7,5};
    int[] test1 = new int[]{4,2,3,1,2};
    int[] test2 = new int[]{1,2,4,10,6,8};

    BarGraph testGraph = new BarGraph(test);
    System.out.println(testGraph.toString());



  }


}
