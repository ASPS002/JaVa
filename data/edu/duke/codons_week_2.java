package edu.duke;

import java.util.*;

public class codons_week_2 extends FileResource {

  private static HashMap<String, Integer> myMap;
  private static HashMap<String, Integer> tmpMap;

  public static void main(String args[]) {
    String plays[] = {
      "caesar.txt",
      "hamlet.txt",
      "likeit.txt",
      "macbeth.txt",
      "romeo.txt",
    };
    myMap = new HashMap<String, Integer>();
    for (int i = 0; i < plays.length; i++) {
      FileResource resource = new FileResource(plays[i]);
      allfive(resource, i);
    }
    int ans = 0;
    for (String s : myMap.keySet()) {
    //   System.out.println(s + " " + myMap.get(s));
      if (myMap.get(s) == 4) ans++;
    }
     System.out.println(ans);
  }

  public static void allfive(FileResource resource, int index) {
    tmpMap = new HashMap<String, Integer>();
    for (String s : resource.words()) {
      if (!tmpMap.containsKey(s)) {
        tmpMap.put(s, 1);
      }
    }
    for (String s : tmpMap.keySet()) {
      if (myMap.containsKey(s)) {
        myMap.put(s, myMap.get(s) + 1);
      } else {
        myMap.put(s, 1);
      }
    }
  }
  //   public static void getsize(int start, String s) {
  //     myMap = new HashMap<String, Integer>();
  //     for (int i = start; i < s.length(); i += 3) {
  //       String tmp = "";
  //       if (i + 2 < s.length()) {
  //         tmp += s.charAt(i);
  //         tmp += s.charAt(i + 1);
  //         tmp += s.charAt(i + 2);
  //         if (!myMap.containsKey(tmp)) {
  //           myMap.put(tmp, 1);
  //         } else {
  //           myMap.put(tmp, myMap.get(tmp) + 1);
  //         }
  //       }
  //     }
  //   }
}
