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

    System.out.println("Problem 2:");
    System.out.println(isPermutation("qwertyuiop","poiuytrewq"));
    System.out.println(isPermutation("qwertyuiop","poiutyrewq"));
    System.out.println(isPermutation("",""));
    System.out.println(isPermutation("q","p"));
    System.out.println(isPermutation("q","q"));
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

  //given two strings, write a method to decide if one is a permutation of the other
  public static boolean isPermutation(String s, String t) {

    Hashtable<Character, Integer> chars = new Hashtable<Character, Integer>();
    Hashtable<Character, Integer> chars2 = new Hashtable<Character, Integer>();

    for(char x: s.toCharArray()) {
      if(chars.contains(x)) {
        chars.put(x,chars.get(x)+1);
      }
      else {
        chars.put(x,1);
      }
    }

    for(char y: t.toCharArray()) {
      if(chars2.contains(y)) {
        chars2.put(y,chars2.get(y)+1);
      }
      else {
        chars2.put(y,1);
      }
    }

    Set<Character> vals = chars.keySet();

    for(char x: vals) {
      if(chars2.containsKey(x)&&chars2.get(x)==chars.get(x)) {
        continue;
      }
      else {
        return false;
      }
    }
    return true;
  }

  //replaces all spaces in a string with '%20' - assumed that string has sufficient
  //space at end to hold additional characters, and you are given true length of string



}
