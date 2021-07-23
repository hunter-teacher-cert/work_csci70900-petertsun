// Team for binary Search
// Brian Mueller
// Mamudu Wally
//Peter Tsun

import java.io.*;
import java.util.*;



public class SortDemo{

  /* Instance Variables */
  private ArrayList<Integer> data;  // to store the data
  private Random r;


  public SortDemo(){
    data = new ArrayList<Integer>();
    r = new Random();
    for (int i=0;i<15;i++){
      data.add(r.nextInt(20)); // [0,19]
    }

  }

  public SortDemo(int size){
    data = new ArrayList<Integer>();
    r = new Random();
    for (int i=0;i<size;i++){
      data.add(r.nextInt(20));
    }

  }

  public int get(int i) {
    return data.get(i);
  }








  public String toString(){
    return ""+data;
  };



  /*------------------------- QUICKSORT STUFF -----------------*/

  public ArrayList<Integer> qsort(ArrayList<Integer> a){
    int lenList = a.size();
    if (lenList < 2) {
      return a;
    }
    int medianIndex = findMedian(a);
    ArrayList<Integer> lessList = new ArrayList<Integer>();
    ArrayList<Integer> greaterList = new ArrayList<Integer>();

    for (int i = 0; i < lenList; i++) {
      if (i != medianIndex) {
        if (a.get(i) <= a.get(medianIndex)) {
          lessList.add(a.get(i));
        } else { // a.get(medianIndex) < a.get(i)
          greaterList.add(a.get(i));
        }
      }
    }
    System.out.println(lessList);
    System.out.println(greaterList);
    lessList = qsort(lessList);
    greaterList = qsort(greaterList);
    ArrayList<Integer> returnList = new ArrayList<Integer>();
    if (lessList.isEmpty()) {
      returnList.add(a.get(medianIndex));
      for (int i = 0; i < greaterList.size(); i++) {
        returnList.add(greaterList.get(i));
      }
    } else {
        returnList = lessList;

        returnList.add(a.get(medianIndex));
        if (!greaterList.isEmpty()) {
          for (int i = 0; i < greaterList.size(); i++) {
            returnList.add(greaterList.get(i));
          }
        }
    }
    return returnList;

  }


  // Preconditions: a is ArrayLists of Integers
  // Return: the index of the median out of a[0], a[last], a[middle]
  private int findMedian(ArrayList<Integer> a){
    int medianIndex = 0;
    int len = a.size();
    if (len < 3) {
      return medianIndex;
    } //o.w. there are more than 2 items.  check 3 samples
    if ((a.get(0) >= a.get(len/2) && a.get(0) < a.get(len - 1)) ||
        (a.get(0) >= a.get(len - 1) && a.get(0) < a.get(len/2))) {
      medianIndex = 0;  //    a[mid] <= a[0] < a[last]
    } else if ((a.get(len/2) >= a.get(0) && a.get(len/2) < a.get(len - 1)) ||
               (a.get(len/2) >= a.get(len - 1) && a.get(len/2) < a.get(0))) {
      medianIndex = len/2;
    } else if ((a.get(len - 1) >= a.get(0) && a.get(len - 1) < a.get(len/2)) ||
               (a.get(len - 1) >= a.get(len/2) && a.get(len - 1) < a.get(0))) {
      medianIndex = len -1;
    }

    return medianIndex;
  }



  public void testFindMedian(){


    System.out.println(this.data);
    System.out.println(findMedian(this.data));

  }

  public ArrayList<Integer> qsortTest() {
    return qsort(data);
  }




}
