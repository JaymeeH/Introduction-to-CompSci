// Lab 10 Heaps / Jaymee Hyppolite
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.PriorityQueue;

import java.io.File;

import java.io.FileNotFoundException;


import java.util.Scanner;
public class main {
	// Driver for Q1
	   public static void main(String[] args) {
	       List<String> asList = new ArrayList<String>();
	       try (BufferedReader br = new BufferedReader(new FileReader("C:\\ArunTest\\temp\\test.txt")))
	       {

	           String sCurrentLine;

	           while ((sCurrentLine = br.readLine()) != null) {
	               asList.add(sCurrentLine);
	           }

	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	       heap.testHeapUsingPriorityQueue(asList);
	       //Driver for Q2 part 1
	       PriorityQueue<Patient> pq =new PriorityQueue<>(idComparator);

	     //opening file for reading

	     Scanner sc=null;

	     try {

	     sc = new Scanner(new File("Patient.txt"));

	     } catch (FileNotFoundException e) {

	     //if opening of file encounter error

	     System.out.println(e.getMessage());

	     //then exiting the application

	     System.exit(-1);

	     }

	     System.out.println("List the input records");

	     while(sc.hasNext()) {

	     //reading record line by line

	     String line=sc.nextLine().trim();

	     //splitting by ,

	     String temp[]=line.split("\\,");

	     //constructing the patient object

	     Patient patient = new Patient(Integer.valueOf(temp[0]),

	     temp[1],temp[2]);

	     //printing the object

	     System.out.println(patient);

	     //adding to queue

	     addToQueue(pq, patient);

	     }

	     System.out.println("\n\nPriority queue using Comparator:");

	     //printing the priority queue

	     pollFromQueue(pq);

	     sc.close();
	       
	    // Driver for Q2 part 2
	       Comparator<String> next= new StringLengthComparator();
		   PriorityQueue<String> value =
		   new PriorityQueue<String>(10, next);
		   value .add("short");
		   value .add("very long indeed");
		   value .add("medium");
		   while (value .size() != 0)
		   {
		   System.out.println(value .remove());
		   }
		   
	   }
	   
	   
	   
	
}




class heap {

   public static void testHeapUsingPriorityQueue(List<String> asList){
       
         /* PriorityQueue<String> minheap=new PriorityQueue<String>(1,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.equals(o2))
                   return 0;
                else return -1;
            }
        });
     
       minheap.add(asList.toString());
        System.out.println("Minheap---------------------");
        System.out.println(Arrays.toString(minheap.toArray()));
        for (Iterator iterator = minheap.iterator(); iterator.hasNext();) {
            System.out.println("Min : "+minheap.element());
            System.out.println("Removing " + minheap.element());
            minheap.remove();
        }
   */
        //create a new object and add a custom comparator that provides the "MaxHeap" behaviour.
        PriorityQueue<String> maxheap=new PriorityQueue<String>(1,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               if(o1.equals(o2))
                       return 0;
                    else if(o1.length()>o2.length())
                    {
                       return 1;
                    }else
                       return -1;
            }
        });
        System.out.println("---------------Maxheap---------------------");
        //add elements
        maxheap.add(asList.toString());
      // System.out.println(Arrays.toString(maxheap.toArray()));
        for (Iterator iterator = maxheap.iterator(); iterator.hasNext();) {
            System.out.println("Max : "+maxheap.element());
            System.out.println("Removing " + maxheap.element()+"\n\n");
            maxheap.remove();
        }     
   }

}
class PatientPriorityQueue {



//method for adding the person to queue

public static void addToQueue(PriorityQueue<Patient> pq,Patient patient) {

pq.add(patient);

}

//this will poll the patient from queue and print it

public static void pollFromQueue(PriorityQueue<Patient> pq) {

while(true) {

Patient patient = pq.poll();

if(patient==null)break;

System.out.println(patient);

}

}

//Comparator for comparing the patient id

public static Comparator<Patient> idComparator = new Comparator<Patient>(){

@Override

public int compare(Patient c1, Patient c2) {

return (int) (c1.getId() - c2.getId());

}

};

}



//Q2 part 2
class StringLengthComparator implements Comparator<String>
{
@Override
public int compare(String x, String y)
{

if (x.length() < y.length())
{
return -1;
}
if (x.length() > y.length())
{
return 1;
}
return 0;
}
}
