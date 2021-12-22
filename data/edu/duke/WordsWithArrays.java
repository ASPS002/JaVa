package edu.duke;

import java.io.*;
import java.util.ArrayList;

public class WordsWithArrays {

  private static ArrayList<String> myWords;
  private static ArrayList<Integer> myFreqs;
  private static ArrayList<String> myName;

  public static void main(String args[]) {
    readfile();
  }

  public static ArrayList<String> giveName() {
    try {
      File file = new File("likeit.txt"); //creates a new file instance
      FileReader fr = new FileReader(file); //reads the file
      BufferedReader br = new BufferedReader(fr); //creates a buffering character input stream
      //   StringBuffer sb = new StringBuffer(); //constructs a string buffer with no characters
      String line;
      while ((line = br.readLine()) != null) {
        // sb.append(line); //appends line to string buffer
        // sb.append("\n"); //line feed
        String tmp = line;
        String app = "";
        for (int i = 0; i < tmp.length(); i++) {
            if(Character.isLetter(tmp.charAt(i)))
          app += tmp.charAt(i);

          if (tmp.charAt(i) == ' '&&app.length()>0) break; else if (app.length()>0&&tmp.charAt(i) == '.') {
            myName.add(app);
            break;
          }
        }
        
      }
      fr.close();
      return myName;
      //closes the stream and release the resources
      //   System.out.println("Contents of File: ");
      //   System.out.println(sb.toString()); //returns a string that textually represents the object
    } catch (IOException e) {
      e.printStackTrace();
    }
    return myName;
  }

  //   public WordsWithArrays() {
  //     myWords = new ArrayList<String>();
  //     myFreqs = new ArrayList<Integer>();
  //   }

  public static void readfile() {
    myWords = new ArrayList<String>();
    myFreqs = new ArrayList<Integer>();
    myName = new ArrayList<String>();
    giveName();
    // FileResource resource = new FileResource("likeit.txt");
    for (String word : myName) {
      word = word.toLowerCase();
      int index = myWords.indexOf(word);
      if (index == -1) {
        myWords.add(word);
        myFreqs.add(1);
      } else {
        int value = myFreqs.get(index);
        myFreqs.set(index, value + 1);
      }
    }
    System.out.println("Unique_words " + myWords.size());
    String ans = "";
    int mx = 0;
    for (int i = 0; i < myFreqs.size(); i++) {
    //   System.out.println(myWords.get(i) + " " + myFreqs.get(i));
      if (myFreqs.get(i) >=10&&myFreqs.get(i)<=15) {
        ans = myWords.get(i);
        mx = myFreqs.get(i);
      }
    }
    System.out.println(ans+" "+mx);
  }
  // public boolean contains(String[] list, String word, int numStored){
  //     for(int k=0; k < numStored; k++){
  //         if (list[k].equals(word)){
  //             return true;
  //         }
  //     }
  //     return false;
  // }

  // public int countDifferentArray(){
  //     int numStored = 0;
  //     String[] words = new String[myWords.size()];
  //     for(String s : myWords.data()){
  //          if (! contains(words,s, numStored)){
  //              words[numStored] = s;
  //              numStored++;
  //          }
  //     }
  //     return numStored;
  // }

  // public void tester(){
  //     readWords();
  //     System.out.println("number of words read: "+myWords.size());
  //     int unique = countDifferentArray();
  //     System.out.println("array count "+unique);
  // }

}
