import java.io.*;
import java.util.*; 
public class write2 {
    public static  void main(String[] args) 
    {
        simplerandom(50);
    }
    public static void simplerandom(int roll)
    {
        Random rand=new Random();
        int []counts=new int[7];
        for(int i=0;i<roll;i++)
        {
            int d=rand.nextInt(6)+1;
            counts[d]++;

        }
        System.out.println(counts[0]+" "+counts[3]);
    }
}
