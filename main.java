// Recursion Lab ; Jaymee Hyppolite
//beyycP
import java.util.Scanner;
import java.io.File ;

public class main {
	public static void main(String args[]) {
		System.out.println(RecursiveCount.count("Welcome",'e'));
		
		
        
        
	}

}

class RecursiveCount{
	public static int count(String word,char letter) {
		if (word.length() == 0) {
				return 0;
	}
		if (word.length() == 1) {
			if (word.charAt(0)==letter) {
				return 1;
			}
			else { 
				return 0;
				
			}
			
		}
		int count = 0;
		if (word.charAt(0) == letter) {
				count++;
		}
		return count + count(word.substring(1),letter);
	}
	
}

class RecursiveStorage{
	private static final Readable File = null;

	public static long diskUsage(File root) {
		//System.out.println("Enter a new File");
	    long total = root.length();                         
	    if (root.isDirectory()) {                            
	      for (String cdN : root.list()) {             
	        File child = new File(root, cdN);         
	        total += diskUsage(child);                       
	      }
	    }
	    String temp = "Geeks for Geeks";
    
	    System.out.println(total + "\t" + root);             
	    return total;              
	    
	    
	    
	    		
	}
}
//public static long fileSpace(File root)
//public static long fileSpace (String root)