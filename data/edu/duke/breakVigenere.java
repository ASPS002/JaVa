package edu.duke;

public class breakVigenere extends FileResource {

  public static void main(String[] args) {
    // System.out.println("GeeksforGeeks");
    // int key1 = 2;
    // int key2 = 20;
    // FileResource fr = new FileResource();
    // String message=fr.asString();
    FileResource resource = new FileResource("secretmessage1.txt");
    String message = resource.asString();
    // for (String s : resource.words()) {
    //   message += s;
    // }
    // message = message.trim();
    String encrypted1 = "";
    String encrypted2 = "";
    String encrypted3 = "";
    String encrypted4 = "";
    for (int i = 0; i < message.length(); i++) {
      if (i % 4 == 0) {
        encrypted1 += message.charAt(i);
      } else if (i % 4 == 1) {
        encrypted2 += message.charAt(i);
      } else if (i % 4 == 2) {
        encrypted3 += message.charAt(i);
      } else encrypted4 += message.charAt(i);
    }
    // System.out.println(encrypted4);
    // String encrypted=encrypt(message,key);
    // System.out.println(encrypted);
    String decrypted1 = encrypt(encrypted1);
    String decrypted2 = encrypt(encrypted2);
    String decrypted3 = encrypt(encrypted3);
    String decrypted4 = encrypt(encrypted4);
    /*For 2 keys*/
    // int j = 0, k = 0;
    // String decrypted = "";
    // while (j < decrypted1.length() || k < decrypted2.length()) {
    //   if (j < decrypted1.length()) {
    //     decrypted += decrypted1.charAt(j);
    //     j++;
    //   }
    //   if (k < decrypted2.length()) {
    //     decrypted += decrypted2.charAt(k);
    //     k++;
    //   }
    // }
    // System.out.println(decrypted);

    /*For 4 keys*/
    int ii = 0, jj = 0, kk = 0, ll = 0;
    String decrypted = "";
    for (int i = 0; i < message.length(); i++) {
      if (i % 4 == 0) {
        decrypted += decrypted1.charAt(ii++);
      } else if (i % 4 == 1) {
        decrypted += decrypted2.charAt(jj++);
      } else if (i % 4 == 2) {
        decrypted += decrypted3.charAt(kk++);
      } else decrypted += decrypted4.charAt(ll++);
    }

    System.out.println(decrypted.toLowerCase());
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

  public static String encrypt(String input) {
    StringBuilder encrypted = new StringBuilder(input);
    int key = getkey(input);
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
