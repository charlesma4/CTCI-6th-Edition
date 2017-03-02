import java.io.*;
import java.util.*;

public class ArrayList {
  Object[] x;
  int count;
  public ArrayList() {
    x = new Object[10];
    count=0;
  }
  //doubles array length if list full and trying to add new object
  public void resize() {
    Object[] y = new Object[x.length*2];
    for(int i=0; i<x.length; i++) {
      y[i]=x[i];
    }
    x=y;
  }

  //adds object to end of arraylist - resizes if list is full
  public void add(Object o) {
    if(count==x.length) {
      resize();
    }
    x[count++]=o;
  }
  //returns object at specified index - throws exception if index is larger than count
  public Object get(int index) {
    if(index<count) {
      return x[index];
    }
    else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }
  //returns size of current ArrayList
  public int size() {
    return count;
  }
  //Removes object at specified index and moves everything down
  public Object remove(int index) {
    if(index>=count) {
      throw new ArrayIndexOutOfBoundsException();
    }
    int ret = x[index];
    for(int i = index; i<count+1; i++) {
      x[i]=x[i+1];
    }
    count--;
    return ret;
  }
}
