import java.io.*;
import java.util.*;
// your implementation of class Time here

public class Time {
  public int hour;
  public int minute;
  public double second;

  public Time() {
    this.hour = 0;
    this.minute = 0;
    this.second = 0.0;
  }

  public Time(int hour, int minute, double second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public boolean equal(Time t) {
	  if (this.hour == t.hour &&
	      this.minute == t.minute &&
	      this.second == t.second) {
	     return true;
	  } else {
             return false;
	  }


  }

  public String toString() {

	  return String.format("%02d:%02d:%04.1f\n",
		  this.hour, this.minute, this.second);

  }

  public static Time add(Time t1, Time t2) {
	  Time sum = new Time();
	  sum.hour = t1.hour + t2.hour;
	  sum.minute = t1.minute + t2.minute;
	  sum.second = t1.second + t2.second;
	  return sum;

  }





}//end class
