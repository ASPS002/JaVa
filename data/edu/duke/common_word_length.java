
 package edu.duke;
public class common_word_length extends FileResource
{ 
	public static void main(String args[])
	{
		countShakespeare();
	}
    // public static String[] getCommon(){
	// 	FileResource resource = new FileResource("common.txt");
	// 	String[] common = new String[20];
	// 	int index = 0;
	// 	for(String s : resource.words()){
	// 		common[index] = s;
	// 		index += 1;
	// 	}
	// 	return common;
	// }
	
	public static int indexOf(String[] list, String word) {
	    for (int k=0; k<list.length; k++) {
	        if (list[k].equals(word)) {
	               return k;
	           }
	       }
	    return -1;
	}
	
	public static void countWords(FileResource resource,  int[] counts){
		
        for(String word : resource.words()){
			int len=word.length();
			if(!Character.isLetter(word.charAt(len-1)))
            {
                 len--;
            }
            if(len>=counts.length)
            len=counts.length-1;

            counts[len]++;
		}
	}
	public static void  countShakespeare(){
		//String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
			//          "likeit.txt", "macbeth.txt", "romeo.txt"};
	    String[] plays = {"manywords.txt"};
		// String[] common = getCommon();
		int[] counts = new int[50];
		for(int k=0; k < plays.length; k++){
			FileResource resource = new FileResource(plays[k]);
			countWords(resource,counts);
			System.out.println("done with " + plays[k]);
		}
		int mx=0;
        int ans=-1;
		for(int k=0; k < counts.length; k++){
			
           if(counts[k]>mx)
           {
               mx=counts[k];
               ans=k;
           }
		}
        System.out.println("Most Common word "+ans);
	}
}
