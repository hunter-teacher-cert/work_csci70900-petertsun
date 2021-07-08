//Emma Wingreen
//Michele Persaud
//Peter Tsun
/**
   lab skeleton
   encapsulation / SuperArray
   SuperArray is a wrapper class for an array.
   Provides "pass-thru" accessibility to array capabilities:
   - get/set by index
   - get length
   Adds functionality:
   - dynamic capacity
   - auto-grow capacity if necessary
 **/

import java.io.*;
import java.util.*;

public class SuperArray
{
  //instance vars
  private int[] data;           //where the actual data is stored
  private int numberElements;   //number of "meaningful" elements


  // ~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~
  //overloaded constructor -- allows specification of initial capacity
  public SuperArray( int size )
  {
    this.numberElements = 0; //numberElements represents the number of elements filled

    //this refers to a particular instance of the super array object
    //and sets to size elements
    this.data = new int[size];
  }

  //default constructor -- initializes capacity to 10
  public SuperArray()
  {
    // this.numberElements = 0; //numberElements represents the number of elements filled
    //
    // //this refers to a particular instance of the super array object
    // //and sets to a default of 10 elements
    // this.data = new int[10]; //values default to 0

    this(10);
  }


  // ~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~
  public void add( int value )
  {
    // test to see if we need to grow, then grow
    // SIMPLE VERSION DOES NOT AUTO-GROW CAPACITY; INSERT MORE CODE HERE LATER


    //number of elements = 0 does not mean there are zero indexes,

    //it means the array is not yet filled
    //Need to call the add method on SuperArray object
    //data is an array of integers;
    //this.data refers to the data array within the SuperArray object
    //numberElements refers to the next available/empty index in the data array
    // and value is the number
    //To set the value at a particular index, e.g. this.data[0] = 15

    this.add(numberElements, value);

    // if (this.numberElements < this.data.length) {
    //       // add item to data array
    //       //(ex if number of elemement is 4 [3,5,7,9, ] and want to add 11 and 13
    //       //go to the index of number of elements and set it to value  (11); now
    //       //number of elements is 5; now there is no room for 13 so need to call
    //       //the grow function to give us a bigger array; how many indexes do we
    //       //want to add
    //       this.data[numberElements] = value;
    //       this.numberElements++; // now the number of meaningful elements increases by one
    // } else {
    //   this.grow();
    //   this.data[numberElements] = value;
    //   this.numberElements++; // now the number of meaningful elements increases by one
    // }



    // if (this.numberElements == this.data.length) {
    //   this.grow();
    // }


  }//end add()
    //add a new index and a new value;
    //example:  have 3, 5, 9 want 3, 7, 5, 9
    //want to start at the last significant element
    //example index = 1; value = 7; number elements = 3; tempIndex =2
    //Example temp index starts at 3 and index is 1;
    //when 9 moves to index 3 temp index is 2;
    //this.data[2] = this.data[1]; set the value in index 2 to the
    //value in index is 1; so tempindex decreases by 1 and is now 1
    //move 5 over and temp index is 1 and index is 1 so
    //will not run through while loop so go to index 1 and set
    //it to the value 7
    //added a meaningful elment in the list so now we need to
    //increase the numberElements by 1 (3-->4)

  public void add( int index, int value ) {

    if (this.numberElements == this.data.length) {
      this.grow();
    }
    if (index > this.numberElements) {
      System.out.println("You cannot have non-contiguous SuperArray!");
    } else {

      //set the temporary index value to the last filled index
      int tempIndex = numberElements;

      while (tempIndex > index){
        this.data[tempIndex] = this.data[tempIndex - 1]; //update this.data[tempIndex]
        tempIndex--; //decrease tempIndex by 1
      }
      this.data[index] = value;
      this.numberElements++;

    }


  }


  //Example:  original array [3, 5, 7, 9, 11,  ,  ]
  //index [0]=3 [1]=5 [2]=7 [3]=9 [4]=11
  //tempIndex is 2 because want to move the 7 value elements;
  //3, 5, 9,  , 11 so temp index is 3; now tempIndex is 4 don't want
  //loop to run again 3; now need to subtact numberElements (was 5 now 4)

  //remove index 2
  public void remove(int index){
    //set the temporary index [2] value to the last filled index
    int tempIndex = index;
    int endIndex = this.numberElements - 1;

    // shift items down to remove the item at index
    while (tempIndex < endIndex) {
      this.data[tempIndex] = this.data[tempIndex + 1];
      tempIndex++;
    }
    // subtract fom numberElements;
    this.numberElements--;

  }

  public boolean isEmpty()
  {
    //If the number of elements is 0, the array is empty, i.e. return true
    //Otherwise it will return false
    return this.numberElements == 0;
  }

  //go to a given index and find the value; stored there (example index 2 value 15)
  public int get(int index)
  {
    //Declare a new int to store the value
    int value;

    //Set value to the value at the given index
    value = this.data[index];

    //Return value
    return value;
  }

  public int getNumberElements()
  {
    return this.numberElements;
  }



  public String toString()
  {
    //Create an empty string
    String s = "[";

    //Use a for loop to print out the elements in the data array
    //printing [1, 2, 3, so last element does not have a comma]
    for (int i = 0; i < this.numberElements; i++) {
      if (i == this.numberElements - 1) {
        s += this.data[i];
      } else {
        s += this.data[i] + ", ";
      }
    }

    s += "]";

    return s; //return the string
  }//end toString()


  //helper method for debugging/development phase
  public String debug()
  {
    String s = "";
    s = "Size: " + this.data.length;
    s = s + " LastItem: " + numberElements + "  Data: ";
    for (int i = 0; i < numberElements; i++) {
      s = s + data[i] + ", ";
    }
    s = s + "\n";
    return s;
  }//end debug()


  private void grow()
  {
    //pseudocode
    //method 1:  pass input to method (grow paren size); eg:  start at 3 want 15;
    //method 2:  default amount, e.g. add 5 empty indexes
    //start with default and get that working
    //start with array of 10 and add 10 as default within grow METHODS
    //1.  create a new array with a given Size
    //2.  fill it with values from old array and  (no) possibly add new values
    //3.  set new array as default data array
    int[] newData10 = new int[this.numberElements + 10];
    for (int i = 0; i < this.data.length; i++) {
      newData10[i] = this.data[i];
    }
    this.data = newData10;

    // create a new array with extra space
    // Q: How did you decide how much to increase capacity by?

    // copy over all the elements from the old array to the new one

    // point data to the new array
    // Q: How does this look when illustrated using encapsulation diagram?
    // int[] newData = new int[(this.numberElements + 10)];
    // for (int index = 0; index < this.numberElements; index++) {
    //   newData[index] = this.data[index];
    // }
    // this.data = newData;


  }//end grow()

}//end class
