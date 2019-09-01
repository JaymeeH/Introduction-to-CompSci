//Lab 5 // Stacks // Jaymee Hyppolite
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class main {

}

class Q1 {
	private static final String inputFile = "html.dat";
	
	String CheckHtml() {
		
	       boolean FileExists = true;
	       Scanner file = null;
	       try {
	           file = new Scanner(new File(inputFile));
	           Stack<String> tags = new Stack<String>();
	           while (FileExists && file.hasNextLine()) {
	               String line = file.nextLine().trim();
	               int OInd = line.indexOf('<');
	               while (FileExists && (OInd >= 0)) {	                   
	                   int CIND = line.indexOf('>', OInd);
	                   if (CIND >= 0) {
	                	   String tagName = line.substring(OInd + 1, CIND);
	                       if (tagName.charAt(0) == '/') { 

	                           if (tags.size() > 0) {
	                               if (tags.peek().equals(tagName.substring(1))) {
	                                   System.out.println("END TAG: " + tags.pop());

	                               } else {
	                                   System.out.println("\nERROR: Start tag \'" + tags.peek() + "\' and end tag \'" + tagName.substring(1) + "\' found.");
	                                   FileExists = false;

	                               }
	                           } else {
	                               System.out.println("\nERROR: No start tag for \'" + tagName.substring(1) + "\'");
	                               FileExists = false;
	                           }

	                       } else {
	                           
	                           System.out.println("START TAG: " + tags.push(tagName));
	                       }
	                   }

	                   
	                   OInd = line.indexOf('<', OInd + 1);
	               } 
	           } 

	          
	           file.close();

	           
	           if (FileExists)
	               System.out.println("The input file is a matched HTML document");

	       } catch (FileNotFoundException fnfe) {
	           System.out.println("File not found: " + inputFile);
	       }
		return " Done ";
	}
	
}

class Q2{
	static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    } 
	static String infixToPostfix(String exp) 
    { 
        String res = new String(""); 
        Stack<Character> newS = new Stack<>(); 
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i);  
            if (Character.isLetterOrDigit(c)) 
                res += c; 
            else if (c == '(') 
                newS.push(c); 
            else if (c == ')') 
            { 
                while (!newS.isEmpty() && newS.peek() != '(') 
                    res += newS.pop(); 
                  
                if (!newS.isEmpty() && newS.peek() != '(') 
                    return "Expression is not valid";                
                else
                    newS.pop(); 
            } 
            else
            { 
                while (!newS.isEmpty() && Prec(c) <= Prec(newS.peek())) 
                    res += newS.pop(); 
                newS.push(c); 
            } 
       
        }  
        while (!newS.isEmpty()) 
            res += newS.pop(); 
       
        return res; 
    } 
}