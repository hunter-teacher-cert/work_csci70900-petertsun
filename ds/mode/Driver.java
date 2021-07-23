// Team Emma Wingreen, Julian Irimina, Peter Tsun


import java.io.*;
import java.util.*;

public class Driver{

  public static void main(String[] args) {
    long start, elapsed;
    int mode;

    Mode m = new Mode(30);
    start = System.currentTimeMillis();
    mode = m.calcMode();
    System.out.println(m);
    System.out.println(mode);
    elapsed = System.currentTimeMillis() - start;
    System.out.println(elapsed);


/*
    System.out.println(m);
    System.out.println("Test smallestValue");
    System.out.println(m.findSmallestValue());
    System.out.println("Test frequency(0):");
    System.out.println(m.frequency(0));

    System.out.println("Test frequency(1):");
    System.out.println(m.frequency(1));
    */

    //System.out.println(m);





  }

}
