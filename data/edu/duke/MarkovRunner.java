package edu.duke;
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovRunner {
    public static void main(String args[])
    {
        runMarkov();
    }
    public static void runModel(IMarkovModel markov, String text, int size,int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            // printOut(st); 
        } 
    } 

    // public static void runModel(MarkovZero markov, String text, int size, int seed){ 
    //     markov.setTraining(text); 
    //     markov.setRandom(seed);
    //     // System.out.println(markov.testGetFollowsWithFile("he"));
    //     System.out.println("running with " + markov); 
    //     for(int k=0; k < 3; k++){ 
           
    //         String st = markov.getRandomText(size); 
    //         printOut(st); 
    //     } 
    // } 

    public static void runMarkov() { 
        FileResource fr = new FileResource("confucius.txt"); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        // MarkovZero markov=new MarkovZero();
        // runModel(markov,st, 200,365);
        markov4interface markov=new  markov4interface();
        runModel(markov, st,200,792);
        // MarkovWordOne markovWord = new MarkovWordOne(); 
        // runModel(markovWord, st, 200); 
    } 

    private static void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    } 

}
