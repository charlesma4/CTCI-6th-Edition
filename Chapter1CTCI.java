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
    System.out.println(isPermutation("ppfffoooaassddee","pfoasdepfoasdefo"));
    System.out.println(isPermutation("",""));
    System.out.println(isPermutation("q","p"));
    System.out.println(isPermutation("q","q"));

    System.out.println("Problem 3: ");
    System.out.println(URLify(" ".toCharArray(),1));
    System.out.println(URLify("hello".toCharArray(),5));
    System.out.println(URLify("Hi my name is Charles    ".toCharArray(),21));
    System.out.println(URLify("".toCharArray(),0));

    System.out.println("Problem 4: ");
    System.out.println(permutationIsPalindrome("qqwweerrtttttyyuuiiiioooooo"));
    System.out.println(permutationIsPalindrome("u"));
    System.out.println(permutationIsPalindrome("qq"));
    System.out.println(permutationIsPalindrome("iririririririri"));
    System.out.println(permutationIsPalindrome(""));
    System.out.println(permutationIsPalindrome("tacocat"));

    System.out.println("Problem 6: ");
    System.out.println(stringCompression("aabbccddeeff"));
    System.out.println(stringCompression("aaabbccddeeee"));
    System.out.println(stringCompression("aaafffffeeeeerererererererere"));
    System.out.println(stringCompression("ab"));
    System.out.println(stringCompression("a"));
    System.out.println(stringCompression(""));
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
      if(chars.containsKey(x)) {
        chars.put(x,chars.get(x)+1);
      }
      else {
        chars.put(x,1);
      }
    }

    for(char y: t.toCharArray()) {
      if(chars2.containsKey(y)) {
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
  public static String URLify(char[] str, int tlength) {

    String ret = "";
    int index = 0;

    for(int i = 0; i<tlength; i++) {
      if(str[i]==32) {
        ret+=new String(str).substring(index,i)+"%20";
        index=i+1;
      }
    }

    for(int i = index;i<str.length;i++) {
      if(str[i]==32) {
        ret+=new String(str).substring(index,i);
        break;
      }
    }

    return ret;

  }

  //Returns true if given string has a permutation that is a palindrome - Returns
  //false if it doesn't
  public static boolean permutationIsPalindrome(String str) {

    Hashtable<Character, Integer> freqs = new Hashtable<Character, Integer>();
    int count=0;

    for(char x: str.toCharArray()) {
      if(freqs.containsKey(x)) {
        freqs.put(x,freqs.get(x)+1);
      }
      else {
        freqs.put(x,1);
      }
    }

    Set<Character> keys = freqs.keySet();

    for(char x: keys) {
      if(freqs.get(x)%2==1) {
        count++;
      }
    }
    return count<=1 ;
  }

  //Takes a string and returns a compressed version of it e.g. aaaabbbbcccddee ->
  //a4b4c3d2e2
  public static String stringCompression(String str) {

    char current = 0;
    int count = 0;
    String ret = "";
    char[] string = str.toCharArray();

    if(str.length()<=2) {
      return str;
    }

    for(int i = 0; i<string.length; i++) {
      if(i!=0&&string[i-1]!=string[i]) {
        ret+=""+current+count;
        count=0;
      }
      if(count==0) {
        current=string[i];
      }
      if(string[i]==current) {
        count++;
      }
    }
    ret+=""+current+count;
    if(ret.length()>=str.length()) {
      return str;
    }
    else {
      return ret;
    }
  }
}
