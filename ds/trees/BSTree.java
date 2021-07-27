import java.io.*;
import java.util.*;
public class BSTree {
  private TreeNode root;
  public BSTree(){
    root = null;
  }

  public void delete(int key){

    // if the tree is empty, nothing to delete
    if (root==null){
      return;
    }


    // find the node that we want to delete
    // and the node above it using piggybacking
    TreeNode front = root;
    TreeNode trailer = root;

    // do the piggyback loop
    // until we either find the node or null
    // if the key isn't present
    while (front != null && front.getData() != key ){
      if (front.getData() < key){
        trailer = front;
        front = front.getRight();
      } else {
        trailer = front;
        front = front.getLeft();
      }
    }

    // if the key wasn't in the tree
    if (front == null){
      return;
    }

    // if we get here
    // front points to the node we want to delete
    // and trailer points to the one above it

    // case 1 -- the node we want to delete is a leaf
    if (front.getLeft() == null &&
    front.getRight() == null) {

      // repoint front's parent to null
      if(front.getData() > trailer.getData()){
        trailer.setRight(null); //previous
      }
      else if (front.getData() < trailer.getData()){
        trailer.setLeft(null);
      }
      else {  // front == trailer values
        root = null; //if root is being deleted with no children
      }
    } else if (front.getLeft() != null && front.getRight() == null) {
                 // check to see if front has one child
      // repoint front's parent to front's child
      if (front.getData() > trailer.getData()) { // front to right of trailer
        trailer.setRight(front.getLeft()); // left of front not empty
      } else { // front to the left of trailer
        trailer.setLeft(front.getLeft());// left of front not empty
      }
    } else if (front.getRight() != null && front.getLeft() == null) {
      if (front.getData() > trailer.getData()) { //front to the right of trailer
        trailer.setRight(front.getRight()); // right of front not empty
      } else {  // front to the left of the trailer
        trailer.setLeft(front.getRight()); // right of front not empty
      }

    } else {
      // front has two children
      //
      //find the node with the largest value on front's left subtree
      TreeNode max = front.getLeft();

      // While there is a greater number (something on the right)
      while (max.getRight() != null){
        max = max.getRight();
      }

      //and replace front with it
      delete(max.getData()); //delete the data
      front.setData(max.getData()); //sets front to new value


    }

  }


  private void preorderTraverse(TreeNode current){
    if (current == null)
    return;

    //process the current node
    System.out.print(current.getData()+", ");

    // recursively print out the left subtree
    preorderTraverse(current.getLeft());

    // recursively print out the right subtree
    preorderTraverse(current.getRight());
  }

  public void preorderTraverse(){
    preorderTraverse(root);
    System.out.println();
  }

  private void postorderTraverse(TreeNode current){
    if (current == null)
    return;

    // recursively print out the left subtree
    postorderTraverse(current.getLeft());

    // recursively print out the right subtree
    postorderTraverse(current.getRight());

    //process the current node
    System.out.print(current.getData()+", ");



  }

  public void postorderTraverse(){
    postorderTraverse(root);
    System.out.println();
  }

  private void inorderTraverse(TreeNode current){
    if (current == null)
    return;


    // recursively print out the left subtree
    inorderTraverse(current.getLeft());

    //process the current node
    System.out.print(current.getData()+", ");

    // recursively print out the right subtree
    inorderTraverse(current.getRight());
  }

  public void inorderTraverse(){
    inorderTraverse(root);
    System.out.println();
  }


  public int search(int key){
    TreeNode current = root;
    // System.out.println(root.getData());
    while (current != null){
      int currentValue = current.getData();
      // System.out.println(currentValue);
      if (currentValue == key){
        System.out.println("Found value");
        return currentValue;      } else if (currentValue < key){
          System.out.println("Going to the right");
          current = current.getRight();
        } else{  //if currentValue > key)
          System.out.println("Going to the left");
          current = current.getLeft();
        }
      }
      // do we really want to return -1?
      throw new NullPointerException();
    }

    public void insert(int key){

      TreeNode newNode = new TreeNode(key);

      // if the tree is empty
      // manually insert the new node as the root
      if (root==null){
        root = newNode;
        return;
      }

      TreeNode front = root;
      TreeNode trailer = root;

      while (front != null){
        int frontValue = front.getData();
        if (frontValue == key){
          // if we're here, it means the key is
          // already in the tree so we can
          // update this node in some way
          // and then return
          return;
        } else if (frontValue < key){
          trailer = front;
          front = front.getRight();
        } else {
          trailer = front;
          front = front.getLeft();
        }
      }
      if (key > trailer.getData()){
        // insert on the right
        trailer.setRight(newNode);
      } else {
        // insert on left
        trailer.setLeft(newNode);

      }



    }

    public void seed(){
      TreeNode t;    t = new TreeNode(10);
      root = t;
      // System.out.println(root.getData());
      t = new TreeNode(5);
      root.setLeft(t);
      // System.out.println(root.getLeft().getData());
      t = new TreeNode(20);
      root.setRight(t);    root.getLeft().setRight( new TreeNode(8));    t = new TreeNode(15);
      root.getRight().setLeft(t);    t = new TreeNode(22);
      root.getRight().setRight(t);
    }
  }
