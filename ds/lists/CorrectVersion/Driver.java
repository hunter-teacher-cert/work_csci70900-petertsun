import java.io.*;
import java.util.*;

public class Driver{
  public static void main(String[] args) {
    Llist berryList = new Llist();


    berryList.addFront("blackberry");

    berryList.addFront("blueberry");
    berryList.addFront("raspberry");
    berryList.addFront("strawberry");
    berryList.addFront("lingonberry");


    System.out.println(berryList);


    berryList.insert(4, "cranberry");
    System.out.println(berryList);

    berryList.remove(1);

    System.out.println(berryList);

    Llist carList = new Llist();
    carList.addFront("camry");
    carList.addFront("accord");

    System.out.println(carList);
    carList.remove(0);
    System.out.println(carList);










  }
}
