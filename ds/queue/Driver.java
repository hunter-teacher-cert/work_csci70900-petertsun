import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
	// Node n;
	// n = new Node();
	// n.setData("Eduardo");
  //
  //
	// Node n2 = new Node("Brian");
	// n.setNext(n2);
  //
	// System.out.println(n);
  //
	// System.out.println(n2);
  //
	// System.out.println(n.getNext());
	// n.getNext().setNext(new Node("Steph"));
	// System.out.println(n2.getNext());
	// System.out.println(n.getNext().getNext());

	//Node L;
	// 1.Create a new  list that looks like:
	//   L->"a"->"b"->"c"->"d"
	// 2. Write the code to insert an "x"
	//    between the b and the c
	// 3. Write the code to delete the c

/*
  Node L = new Node();
  Node d = new Node("d");
  Node c = new Node("c", d);
  Node b = new Node("b", c);
  Node a = new Node("a", b);
  L.setNext(a);

  Node tempNode = L;
  while (tempNode != null) {
    System.out.print(tempNode.getData() + " ");
    tempNode = tempNode.getNext();
  }
  System.out.println("null");

  System.out.println("Part2");

  Node x = new Node("x", c);
  b.setNext(x);

  tempNode = L;
  while (tempNode != null) {
    System.out.print(tempNode.getData() + " ");
    tempNode = tempNode.getNext();
  }
  System.out.println("null");



    System.out.println("Part3");
  x.setNext(d);

  tempNode = L;
  while (tempNode != null) {
    System.out.print(tempNode.getData() + " ");
    tempNode = tempNode.getNext();
  }
  System.out.println("null");
*/
/*
Llist lls = new Llist();
lls.addLast("watermelon");
System.out.println(lls);
lls.addFront("apple");
lls.addFront("orange");
System.out.println(lls);


lls.addLast("grapefruit");
System.out.println(lls);
*/

     Queue testQueue = new Queue();

     System.out.println(testQueue.toString());
     System.out.println(testQueue.isEmpty());
     int len = testQueue.size();

     System.out.println(len);
     testQueue.enqueue("blueberry");
     System.out.println(testQueue);
      len = testQueue.size();
     System.out.println(len);
     testQueue.enqueue("strawberry");
     System.out.println(testQueue);
      len = testQueue.size();
     System.out.println(len);
     testQueue.enqueue("blackberry");
     System.out.println(testQueue);
      len = testQueue.size();
     System.out.println(len);
     testQueue.dequeue();
     System.out.println(testQueue);
      len = testQueue.size();
     System.out.println(len);
     System.out.println(testQueue.front());
     System.out.println(testQueue.isEmpty());


    }
}
