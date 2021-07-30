import java.io.*;
import java.util.*;


public class HashTable {
    int size = 16; // size of hash-table array
    Llist[] buckets;

    public HashTable() {
        buckets = new Llist[size];
    }

    public boolean isEmpty() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                return false;
            }
        }
        return true; // after going through all the bins, cannot find empty bins
    }

    public String toString(){
        String result = "";
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) {
                result = result + "bin[" + i + "]: {}\n";
            } else {
                result = result + "bin[" + i + "]: " + buckets[i].toString() + "\n";
            }
        }
        return result;
    }

    public int hashCode(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum = sum + key.charAt(i) % 7;
        }
        return sum;
    }

    public void put(String key, String value) {
        int hashCode = hashCode(key);
        int index = hashCode % size; // original is size 16

        if (buckets[index] == null) {
            buckets[index] = new Llist();
            buckets[index].addFront(hashCode, key, value);
        } else {    // link list buckets[index] is not empty
            buckets[index].addFront(hashCode, key, value);
        }
    }

    public boolean hasKey(String key) {
        int hashCode = hashCode(key);
        int index = hashCode % size; // original is size 16

        if (buckets[index] == null) {
            return false;
        }

        if (buckets[index].search(key) == -1) { // index in llist cannot be negative
            return false;
        } else {
            return true;
        }
    }

    public String get(String key) {
        int hashCode = hashCode(key);
        int index = hashCode % size; // index for the array of llist's

        if (hasKey(key)) {
            int binIndex = buckets[index].search(key);
            return buckets[index].getValue(binIndex);
        }
        return null;
    }

    public void remove(String key) {
        int hashCode = hashCode(key);
        int index = hashCode % size;

        if (hasKey(key)) {
            int binIndex = buckets[index].search(key);
            buckets[index].remove(binIndex);
        }

    }



}
