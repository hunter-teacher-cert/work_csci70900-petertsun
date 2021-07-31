
//Peter Tsun

import java.io.*;
import java.util.*;

public class SortDemoDriver {
  public static void main(String[] args) {

    SortDemo sd = new SortDemo(); // default size: 15
    //System.out.println(sd);


    /* part 2 test lines */
    SortDemo sd2 = new SortDemo(); // default size: 15




    System.out.println("Testing iteration method of heapsort");

    sd2.testHeapSort();

    System.out.println("Testing recurive method of heapsort");

    sd.testBubbleMaxHeapSort();




  }
}
