package edu.duke;

import java.util.*;

public class markov4interface implements IMarkovModel {

  private String myText;
  private Random myRandom;
  private HashMap<String, ArrayList<String>> hp;

  public markov4interface() {
    myRandom = new Random();
  }

  public void setRandom(int seed) {
    myRandom = new Random(seed);
  }

  public void setTraining(String s) {
    myText = s.trim();
    hp = new HashMap<String, ArrayList<String>>();
  }

  public String getRandomText(int numChars) {
    if (myText == null) {
      return "";
    }
    int index = myRandom.nextInt(myText.length() - 6);
    String key = myText.substring(index, index + 6);
    StringBuilder sb = new StringBuilder();
    sb.append(key);
    for (int k = 0; k < numChars - 6; k++) {
      if (!hp.containsKey(key)) {
        ArrayList<String> follows = getFollows(key);
        index = myRandom.nextInt(follows.size());
        String next = follows.get(index);
        sb.append(next);
        key = key.substring(1) + next;
      }
      else
      {
        ArrayList<String> follows = hp.get(key);
        index = myRandom.nextInt(follows.size());
        String next = follows.get(index);
        sb.append(next);
        key = key.substring(1) + next;
      }
    }
    System.out.println(hp.size());
    return sb.toString();
  }

  public int testGetFollowsWithFile(String key) {
    ArrayList<String> follows = getFollows(key);
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
    hp.put(key,follows);
    return follows;
  }
}
