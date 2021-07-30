import java.io.*;
import java.util.*;

public class Node {

    private int hash;
    private String key;
    private String value;
    Node next;

    public Node() {
        hash = 0;
        key = null;
        value = null;
        next = null;
    }

    public Node(String keyText) {
        this(9, keyText, null, null);
    }

    public Node(String keyText, String value) {
        this(9, keyText, value, null);
    }

    public Node(int hashCode, String keyText, String valueList) {
        this(hashCode, keyText, valueList, null);
    }

    public Node(int hashCode, String keyText, String valueText, Node reference2NextNode) {
        hash = hashCode;
        key = keyText;
        value = valueText;
        next = reference2NextNode;
    }

    public void setHash(int hashCode) {
        hash = hashCode;
    }

    public void setKey(String keyText) {
        key = keyText;
    }

    public void setValue(String valueList) {
        value = valueList;
    }

    public void setNext(Node reference2NextNode) {
        next = reference2NextNode;
    }

    public int getHash() {
        return hash;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }


    public String toString() {
        String result = "";
        result = result + key + " : " + value;
        return result;
    }








}
