package edu.duke;

/**
 * Write a description of class MarkovZero here.
 *
 * @author Duke Software
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovZero {

  private String myText;
  private Random myRandom;

  public MarkovZero() {
    myRandom = new Random();
  }

  public void setRandom(int seed) {
    myRandom = new Random(seed);
  }

  public void setTraining(String s) {
    myText = s.trim();
  }

  //   public String getRandomText(int numChars) {
  //     if (myText == null) {
  //       return "";
  //     }
  //     StringBuilder sb = new StringBuilder();
  //     for (int k = 0; k < numChars; k++) {
  //       int index = myRandom.nextInt(myText.length());
  //       sb.append(myText.charAt(index));
  //     }

  //     return sb.toString();
  //   }
  public String getRandomText(int numChars) {
    if (myText == null) {
      return "";
    }
    int index = myRandom.nextInt(myText.length() - 1);
    String key = myText.substring(index, index + 1);
    StringBuilder sb = new StringBuilder();
	sb.append(key);
    for (int k = 0; k < numChars-1; k++) {
	  ArrayList<String>follows=getFollows(key);
	  index = myRandom.nextInt(follows.size());
	  String next=follows.get(index);
      sb.append(next);
	  key=next;

    }

    return sb.toString();
  }
  public int testGetFollowsWithFile(String key)
  {
    ArrayList<String>follows=getFollows(key);
	return follows.size();
  }
  public ArrayList<String> getFollows(String key) {
    ArrayList<String> follows = new ArrayList<>();
    int pos = 0;
    while (pos < myText.length()) {
      int start = myText.indexOf(key, pos);
      if (start == -1) {
        break;
      }
      if (start + key.length() >= myText.length()) {
        break;
      }
      String next = myText.substring(
        start + key.length(),
        start + key.length() + 1
      );
      follows.add(next);
      pos = start + key.length();
    }
    return follows;
  }
}
