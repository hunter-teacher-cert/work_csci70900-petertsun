import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {

        HashTable hmap = new HashTable();

        System.out.println(hmap.toString());

        hmap.put("repeat", "loop");
        hmap.put("conditional", "if");
        hmap.put("self-employ", "recursive");
        hmap.put("kind", "type");
        hmap.put("characteristic", "attribute");
        hmap.put("characteristic", "field");


        System.out.println(hmap.toString());
        System.out.println(hmap.hasKey("repeat"));
        System.out.println(hmap.hasKey("variable"));
        System.out.println(hmap.hasKey("self-employ"));
        System.out.println(hmap.get("repeat"));
        System.out.println(hmap.get("equal"));
        System.out.println(hmap.get("conditional"));

        hmap.remove("kind");

        System.out.println(hmap.toString());




/*
        String toDo = "Abc";
        System.out.println(hmap.hashCode(toDo) + ", " + hmap.hashCode(toDo) % 16);

        Node n1 = new Node();
        Node n2 = new Node(2, "july", toDo, n1);
        Node n3 = new Node(2, "august", "swim");
        Node n4 = new Node("september", "hike");

        Llist lls = new Llist();

        System.out.println("List is empty: " + lls.isEmpty());
        System.out.println("List's length: " + lls.length());



        lls.addFront("july", toDo);
        lls.addFront("august", "swim");
        lls.addFront("september", "hike");


        System.out.println("List is empty: " + lls.isEmpty());
        System.out.println("List's length: " + lls.length());
        int tempIndex = lls.search("august");
        System.out.println("Search for august's index: " + tempIndex);
        System.out.println("Getting for the key august: " + lls.get(tempIndex));

        System.out.println(lls);
        lls.remove(tempIndex);
        System.out.println(lls);
*/

    }

}
