import java.io.*;
import java.util.*;


public class Llist{
  private Node front; // the front of the list

  public  Llist(){  // the constructor
    front = null;
  }

  // Add a new node containing data
  // at the front of the list
  public void addFront(int hashCode, String key, String value){
    // make the new node
    Node newNode = new Node(hashCode, key, value);

    // point it to what front points to
    newNode.setNext(front);

    // point front to the new node
    front = newNode;

  }

  public String toString(){
    Node currentNode;
    currentNode = front;
    String result = "";
    while (currentNode != null){
      result = result + currentNode + " => ";
      // this is like i=i+1 is for arrays
      // but for linked lists
      currentNode = currentNode.getNext();
    }
    result = result + "null";
    return result;
  }

  // returns True if there is nothing in the list
  // False otherwise
  public boolean isEmpty(){
    return front==null; // could also return !front
  }

  // returns the number of items in the list
  // Hint: look at the toString
  // to remind you how to traverse down the list
  public int length(){
    Node currentNode = front;
    int count = 0;
    while (currentNode != null){
      count = count + 1;
      currentNode = currentNode.getNext();
    }
    return count;
  }

  // returns the item at location index;
  // returns null if there aren't enough
  // items. Starts with index 0
  public String getKey(int index){
    // be careful not to run off the end of the list
    // move a reference to the node we want to get
    // traverse idiom
    int count = 0;
    Node currentNode = front;
    while (currentNode != null && count != index){
      currentNode = currentNode.getNext();
      count = count + 1;
    }

    // once there, return the data in that node
    if (currentNode == null){
      return null;
    } else {
      return currentNode.getKey();

    }


  }

  // returns the item at location index;
  // returns null if there aren't enough
  // items. Starts with index 0
  public String getValue(int index){
    // be careful not to run off the end of the list
    // move a reference to the node we want to get
    // traverse idiom
    int count = 0;
    Node currentNode = front;
    System.out.println(index);

    while (currentNode != null && count != index){
      currentNode = currentNode.getNext();
      count = count + 1;
    }
    // once there, return the data in that node
    if (currentNode == null){
      return null;
    } else {

      return currentNode.getValue();
    }
  }

  // sets the item at location index (starting
  // with 0) to value.
  // only sets if the index is within range
  public void setValue(int index, String value){

    int count = 0;
    Node currentNode = front;
    while (currentNode != null && count != index){
      currentNode = currentNode.getNext();
      count = count + 1;
    }

    // once there, set the new data
    if (currentNode != null){
      currentNode.setValue(value);
    }

  }





  // returns the index of the first item with
  // data value key. Returns -1 if not found
  public int search(String key){
    int count = 0;
    Node currentNode = front;
    while (currentNode != null){
      if (currentNode.getKey().equals(key)){
        return count;
      }
      count = count + 1;
      currentNode = currentNode.getNext();
    }
    return -1;
  }

  // removes the node at index.   ?
  // does nothing if index out of bounds
  public void remove(int index){
    int count = 0;
    Node currentNode = front;
    if (currentNode != null && index == 0){
      front = currentNode.getNext();
      return;
    }
    while (currentNode != null){
      if (count == index - 1){
        currentNode.setNext(currentNode.getNext().getNext());

      }
      count = count + 1;
      currentNode = currentNode.getNext();
    }
  }


}
