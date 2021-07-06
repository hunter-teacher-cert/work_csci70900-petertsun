/*
 * Team 1
 * Chaouiki H.
 * Eric Liu
 * Peter Tsun
 *     instantiate a newly-created Time object (aka "instance of class Time") with default value(s)
    instantiate a newly-created Time object with specified value(s)
    assign a Time var the value null
    assign a Time var the value of an existing Time var
    print all of the above (See multiple ways to do this? Try all -- and document in comments!)
    test for equality of each of the Time instances above. Print results.
    add two Time objects and print results
    add two Time objects and save the result in another Time object

 **/



import java.io.*;
import java.util.*;

public class Driver {




  public static void main(String[] args) {

    //declare a var of appropriate type to assign an instance of Time to
    Time t;
    Time t1;


    //assign var the address of a newly-apportioned Time object
    t = new Time();
    t1 = new Time();
    Time t2 = new Time();

        //System.out.println(t);
    System.out.printf("%02d:%02d:%04.1f\n", t.hour, t.minute, t.second);

    t = new Time(11, 59, 59.9);
    //System.out.println(t.hour, t.minute, t.second);
      // String s=t("2, 59, 59.9");
        //System.out.println(t);
       // System.out.printf("%02d:%02d:%04.1f\n", t.hour, t.minute, t.second);
    System.out.printf("%02d:%02d:%04.1f\n", t.hour, t.minute, t.second);
    System.out.println(t);
    //t1 = t;
    System.out.printf("%02d:%02d:%04.1f\n", t1.hour, t1.minute, t1.second);
    //t1 = null;
    //Time t1 = new Time();

    t1.hour = t.hour;
    t1.minute = t.minute;
    t1.second = 31.1;
    System.out.printf("%02d:%02d:%04.1f\n", t.hour, t.minute, t.second);
    System.out.printf("%02d:%02d:%04.1f\n", t1.hour, t1.minute, t1.second);


//    t2 = null;
 //   System.out.printf("%02d:%02d:%04.1f\n", t2.hour, t2.minute, t2.second);
    System.out.println(t1.equal(t));

    System.out.println(t1.toString());

    System.out.println(Time.add(t1, t).toString());
        t1.hour = 4;
    t2 = Time.add(t1,t);

    System.out.println(t2);

  }//end main()

}//end class
