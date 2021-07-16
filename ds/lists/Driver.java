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
     Llist testLinkedList = new Llist();
     testLinkedList.addFront("Tommy");
     testLinkedList.addFront("Sammy");
     testLinkedList.addFront("Amy");
     System.out.println(testLinkedList);
     testLinkedList.insert(1, "Denny");
     testLinkedList.insert(0, "Vinny");

     System.out.println(testLinkedList.search("Tommy"));


     System.out.println(testLinkedList);



    }
}
