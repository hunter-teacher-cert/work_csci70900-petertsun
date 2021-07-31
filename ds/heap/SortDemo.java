
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
    for (int i=0;i < 5;i++){
      data.add(r.nextInt(50)); // [0,19]
    }
    /*
data.add(31);
data.add(44);
data.add(10);
data.add(36);
data.add(15); */

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



  /*------------------------- HEAPSORT # 1 STUFF -----------------*/

  /*
   * Credits for the first Heapsort code goes to https://www.geeksforgeeks.org/heap-sort/
   * Credits for conceptual understanding goes to
   * https://youtu.be/2DmK_H7IdTo
   * https://youtu.be/qQkfUKer3LU
   * https://youtu.be/cuL8gXCSA58
   * https://youtu.be/kU4KBD4NFtw
   */

  //   Heapify a row of a subtree rooted with node i which is an index
  //   of an arrayList arrList.
  //   n is the size of the heap
  public void max_heapify(ArrayList<Integer> arrList, int n, int i) {
      int largest = i; // Initialize largest as root
      int l = 2 * i + 1; // left = 2 i + 1
      int r = 2 * i + 2;  // right = 2 i + 2

      // if left child is larger than root
      if (l < n && arrList.get(l) > arrList.get(largest)) {
          largest = l;
      }

      // if right child is larger than the largest so far
      if (r < n && arrList.get(r) > arrList.get(largest)) {
          largest = r;
      }

      if (largest != i) {
          swap(arrList, i, largest);
          max_heapify(arrList, n, largest);
      }
  }

  private void swap(ArrayList<Integer> arrList, int i, int j) {
      int tempValue = arrList.get(i);
      arrList.set(i, arrList.get(j));
      arrList.set(j, tempValue);
  }

  public void heapSort(ArrayList<Integer> arrList, int n) {

      // Build heap (rearrange array)
      for (int i = n / 2 - 1; i >=0; i--) { // only work on the interior tree nodes
          max_heapify(arrList, n, i);
      }

      for (int i = n - 1; i > 0; i--) {
          // move current root to the end
          swap(arrList, 0, i);
          max_heapify(arrList, i, 0); // max heapify on the reduced heap
      }
  }




  /*------------------------- HEAPSORT # 2 STUFF -----------------*/

  // Basically the parameter index will always be set to 0.
  // This is a leftover from for iteration loop method
  // The design of this heapify method is purely recursive
  public void heapify(ArrayList<Integer> arrList, int index) {
      int leftIndex = 2 * index + 1;
      int rightIndex = 2 * index + 2;
      int lenList = arrList.size();
      int maxIndex = lenList - 1;

      if (leftIndex > maxIndex) {
          return; // leftIndex out of bound --> the node has no leaves
      }
      heapify(arrList, leftIndex);  // recursive call
      if (rightIndex > maxIndex) { // what to do after recursive call #1
          int largestValueIndex = index;
          if (arrList.get(largestValueIndex) < arrList.get(leftIndex)) {
              largestValueIndex = leftIndex;
          }
          if (index != largestValueIndex) { // swap values at these two indices
              int tempValue = arrList.get(index);
              arrList.set(index, arrList.get(largestValueIndex));
              arrList.set(largestValueIndex, tempValue);
          }
          return; // just rightIndex out of bound. Compare index with leftIndex before swap
      }
      heapify(arrList, rightIndex);  // recursive call
      int largestValueIndex = index; // what to do after recursive call # 2

/*      System.out.println("largestValueIndexindex before 1st if" + largestValueIndex);
      System.out.println("root-lft-right" + arrList.get(largestValueIndex)
                          + " " + arrList.get(leftIndex) + " " + arrList.get(rightIndex)); */

      if (arrList.get(largestValueIndex) < arrList.get(leftIndex)) {
          largestValueIndex = leftIndex;
      }
      if (arrList.get(largestValueIndex) < arrList.get(rightIndex)) {
          largestValueIndex = rightIndex;
      }
      if (index != largestValueIndex) { //swap values at these two indices
          int tempValue = arrList.get(index);
          arrList.set(index, arrList.get(largestValueIndex));
          arrList.set(largestValueIndex, tempValue);
      }
  }

  public ArrayList<Integer> bubbleMaxHeapSort(ArrayList<Integer> arrList) {
      int lenArrList = arrList.size();
      ArrayList<Integer> tempData = new ArrayList<Integer>(arrList.subList(0, lenArrList));

      // Build heap (rearrange array)
      heapify(arrList, 0);
      int max = arrList.get(0);
      for (int i = lenArrList - 1; i >= 0; i--) {
          max = arrList.remove(0);
          tempData.set(i, max);
          heapify(data,0);
      }
      return tempData;

  }


  public void testHeapSort(){


    System.out.println(this.data);
    heapSort(data, 5);
    System.out.println(this.data);

  }

  public void testBubbleMaxHeapSort() {

      System.out.println(this.data);
      data = bubbleMaxHeapSort(this.data);
      System.out.println(this.data);

  }




}
