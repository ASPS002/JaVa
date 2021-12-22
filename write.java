import java.io.*;
import java.io.File;
//import org.apache.commons.csv.*;
import java.util.Scanner; 
class CCipher{
  
    public static  void main(String[] args) 
    {
        // System.out.println("GeeksforGeeks");
        int key=15;
        // FileResource fr = new FileResource();
        // String message=fr.asString();
        String message="Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted=encrypt(message,key);
        System.out.println(encrypted);
        String decrypted=encrypt(encrypted,26-key);
        System.out.println(decrypted);
    }
    public  static String encrypt(String input,int key)
    {
        StringBuilder encrypted=new StringBuilder(input);
         
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String ShiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);

        for(int i=0;i<encrypted.length();i++)
        {
            char currenChar=encrypted.charAt(i);
            int flag=0;
            if(Character.isLowerCase(currenChar))
            {
                flag=1;
                currenChar=Character.toUpperCase(currenChar);
            }
            int idx=alphabet.indexOf(currenChar);
            if(idx!=-1)
            {
                 
                char newChar=ShiftedAlphabet.charAt(idx);
                if(flag==1)
                {
                    newChar=Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();

    }
   

}