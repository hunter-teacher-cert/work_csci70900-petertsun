import java.io.*;
import java.util.*;


public class Llist{
  private Node front; // the front of the list

  public  Llist(){
    front = null;
  }

  // Add a new node containing data
  // at the front of the list
  public void addFront(String data){
    // make the new node
    Node newNode = new Node(data);
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
      result = result + currentNode + "->";
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
  public String get(int index){

    Node currentNode = front;
    int count = 0;
    if (index >= this.length()){
      return null;
    } else {
      while (count != index){
        count = count + 1;
        if (currentNode != null) {
          currentNode = currentNode.getNext();
        } else {
          return null;
        }
      }
    }
    return currentNode.getData();
  }

  // sets the item at location index (starting
  // with 0) to value.
  // only sets if the index is within range
  public void set(int index, String value){
    if (index < this.length()){
      Node currentNode = front;
      int count = 0;
      while (count != index) {
        count = count + 1;
        currentNode = currentNode.getNext();
      }
      currentNode.setData(value);
    }

  }

  // insert an item before index.
  // only inserts if the index is within bounds
  // Hint: look at toString for hints on
  // traversal and draw out a diagram.
  // You will need a variable that refers to
  // the node BEFORE you want to do the insertion.
  public void insert(int index, String value){
    if (index < this.length()){
      Node currentNode = front;
      Node previousNode = null;
      int count = 0;
      while (count != index){
        count = count + 1;
        previousNode = currentNode;
        currentNode = currentNode.getNext();
      }
      Node newNode = new Node(value, currentNode);
      previousNode.setNext(newNode);
    }

  }

  // returns the index of the first item with
  // data value key. Returns -1 if not found
  public int search(String key){
    Node currentNode = front;
    int count = 0;
    while (currentNode != null){
      if (key.equals(currentNode.getData())) {
        return count;
      }
      count = count + 1;
      currentNode = currentNode.getNext();
    }
    return -1;
  }

  // removes the node at index.
  // does nothing if index out of bounds
  public void remove(int index){
    int listLength = this.length();
    if (listLength > 0){
      if (index < listLength){
        Node priorNode = front;
        Node currentNode = front;
        int count = 0;
        while (count != index) {
          count = count + 1;
          priorNode = currentNode;
          currentNode = currentNode.getNext();
        }
        if (index == 0) {
          if (currentNode != null){
            front = currentNode.getNext();
          }
        } else {
          priorNode.setNext(currentNode.getNext());
        }

      }
    }

  }


}
