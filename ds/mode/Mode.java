import java.io.*;
import java.util.*;



public class Mode{
  private ArrayList<Integer> inputData;
  private Random r;
  public Mode(){
    r = new Random();
    inputData = new ArrayList<Integer>();

    for (int i=0; i < 20; i++){
      inputData.add(r.nextInt(20));
    }
  }
  public Mode(int size){
    r = new Random();
    inputData = new ArrayList<Integer>();

    for (int i=0; i < size; i++){
      inputData.add(r.nextInt(50));
    }
  }

  /**
  * Warmup 1

  Find and return the smallest value in  InputData.
  */

  public int findSmallestValue(){

    int smallestValue = inputData.get(0);
    int i;
    int len = inputData.size();
    for (i = 1; i < len; i++) {
      if (inputData.get(i) < smallestValue) {
        smallestValue = inputData.get(i);
      }
    }
    return smallestValue;

  }

  /**
  * Warmup 2

  Returns the frequency of value in inputData, that is, how often value appears
  */
  public int frequency(int value){
    //Initialize a count variable to store the frequency
    int count = 0;

    //Iterate through the ArrayList to find the frequency of "value"
    for(int i = 0; i < inputData.size(); i++) {
      if (inputData.get(i) == value) { //If value is found...
        count++; //...increment count
      }
    }

    return count;

  }

  /**
  *
  This function should calculate and return the mode of inputData.
  The mode is the value that appears most frequently so if inputData contained
  5,3,8,2,5,9,12,5,12,6,5, the mode would return 5 since 5 appears four times.

  If there are multiple modes such as in the case with this data set: 5,5,2,9,9,6 you should return
  either of them (the 5 or the 9).

  Note: you will probably use the frequency function you wrote in
  this solution but not findSmallestValue. the findSmallestValue
  function will help you find a strategy for approaching finding the mode.
  */
  public int calcMode(){
    int modeValue = inputData.get(0);
    int greatestFrequency = this.frequency(modeValue);
    for (int i = 1; i < inputData.size(); i++){
      if (inputData.get(i) != modeValue){
        int currentFrequency = this.frequency(inputData.get(i));
        if (currentFrequency > greatestFrequency){
          modeValue = inputData.get(i);
          greatestFrequency = currentFrequency;
        }
      }
    }

    return modeValue;
  }


  public String toString(){
    return ""+inputData;
  }
}
