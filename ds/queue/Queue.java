import java.io.*;
import java.util.*;


public class Queue{
  private Llist line;


  public Queue(){
    line = new Llist();  // line has a private front field
    //front = line.front;
    //back = line.back;
  }

  // Add a new node containing data
  // to the back of the queue
  public void enqueue(String data) {
    Node newNode = new Node(data);

    line.addLast(data);

  }

  // remove and return the value at the front of the queue
  public String dequeue() {
    String data = line.get(0);
    if (data != null) {
      line.remove(0);
      return data;
    } else {
      return data;
    }

  }

  // return but don't remove the value at the front
  public String front() {
    if (line.get(0) != null) {
      return line.get(0);
    } else {
      return null;
    }
  }

  // returns true if the queue is empty
  public boolean isEmpty() {
    return line.isEmpty();
  }

  // returns the number of items in the queue
  public int size() {
    return line.length();
  }


  public String toString(){
    return this.line.toString();
  }











}
