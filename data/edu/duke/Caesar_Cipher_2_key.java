package edu.duke;

public class Caesar_Cipher_2_key extends FileResource {

  public static void main(String[] args) {
    // System.out.println("GeeksforGeeks");
    // int key1 = 2;
    // int key2 = 20;
    // FileResource fr = new FileResource();
    // String message=fr.asString();
      FileResource resource = new FileResource("likeit.txt");
     String message="Can you imagine life WITHOUT the internet AND computers in your pocket?";
    for(String s : resource.words()){
        // message+=s;
        // message+=" ";
        System.out.println(s);
        break;
    }
    String encrypted1 = "";
    String encrypted2 = "";
    for (int i = 0; i < message.length(); i++) {
      if (i % 2 == 0) encrypted1 += message.charAt(i); else encrypted2 +=
        message.charAt(i);
    }
    // String encrypted=encrypt(message,key);
    // System.out.println(encrypted);
    String decrypted1 = encrypt(encrypted1,21);
    String decrypted2 = encrypt(encrypted2,8);
    int j = 0, k = 0;
    String decrypted = "";
    while (j < decrypted1.length() || k < decrypted2.length()) {
      if (j < decrypted1.length()) {
        decrypted += decrypted1.charAt(j);
        j++;
      }
      if (k < decrypted2.length()) {
        decrypted += decrypted2.charAt(k);
        k++;
      }
    }
    System.out.println(decrypted);
  }

  public static int getkey(String input) {
    StringBuilder encrypted = new StringBuilder(input);
    int[] freq = new int[26];
    for (int i = 0; i < encrypted.length(); i++) {
      if (Character.isLetter(encrypted.charAt(i))) {
        freq[Character.toUpperCase(encrypted.charAt(i)) - 'A']++;
      }
    }
    char mxtime = 'A';
    for (char c = 'A'; c <= 'Z'; c++) {
      if (freq[c - 'A'] > freq[mxtime - 'A']) {
        mxtime = c;
      }
    }
    int key = (mxtime - 'A') - ('E' - 'A');
    if (key < 0) key += 26;
    System.out.println(key);
    return 26 - key;
  }

  public static String encrypt(String input,int key) {
    StringBuilder encrypted = new StringBuilder(input);
    // int key=getkey(input);
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String ShiftedAlphabet =
      alphabet.substring(key) + alphabet.substring(0, key);

    for (int i = 0; i < encrypted.length(); i++) {
      char currenChar = encrypted.charAt(i);
      int flag = 0;
      if (Character.isLowerCase(currenChar)) {
        flag = 1;
        currenChar = Character.toUpperCase(currenChar);
      }
      int idx = alphabet.indexOf(currenChar);
      if (idx != -1) {
        char newChar = ShiftedAlphabet.charAt(idx);
        if (flag == 1) {
          newChar = Character.toLowerCase(newChar);
        }
        encrypted.setCharAt(i, newChar);
      }
    }
    return encrypted.toString();
  }
}
