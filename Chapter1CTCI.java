import java.util.*;
import java.io.*;

public class Chapter1CTCI {

  public static void main(String[] args) {
    System.out.println("Testing\nProblem 1:");
    System.out.println("Hello: "+isUniqueChars("Hello"));
    System.out.println("bye: "+isUniqueChars("bye"));
    System.out.println("BbAaCc: "+isUniqueChars("BbAaCc"));
    System.out.println("Februay: "+isUniqueChars("Februay"));
    System.out.println("Hello: "+isUniqueChars2("Hello"));
    System.out.println("bye: "+isUniqueChars2("bye"));
    System.out.println("BbAaCc: "+isUniqueChars2("BbAaCc"));
    System.out.println("Februay: "+isUniqueChars2("Februay"));

  }

  //returns true if string's chars are all unique, false if not - allowed to use data structures
  public static boolean isUniqueChars(String s) {
    if(s.length()>128) {
      return false;
    }

    boolean[] table = new boolean[128];
    for(int i = 0; i<s.length(); i++) {
      int val = s.charAt(i);
      if(table[val]==true) {
        return false;
      }
      else {
        table[val]=true;
      }
    }
    return true;
  }

  //same as isUniqueChars, but cannot use any additional data structures
  public static boolean isUniqueChars2(String s) {
    for(int i = 0; i<s.length(); i++) {
      for(int j = 0; j<s.length(); j++) {
        if(s.charAt(i)==s.charAt(j)&&i!=j) {
          return false;
        }
      }
    }
    return true;
  }



}
