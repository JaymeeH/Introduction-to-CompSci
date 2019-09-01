// Jaymee Hyppolite /  Lab 7 Dictionaries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
/*
Sam,123 Main Line,555-0469,123-45-6789,2423.07
Carla,456 Off Line,555-0101,987-65-4321,1246.15
Woody,789 Off Rocker,555-0000,010-20-3040,1169.23
Diane,678 Fifth Ave,555-0690,958-47-3625,10.55
Norm,987 Suds Blvd.,555-8374,456-78-9000,11.2
Cliff,321 Duds Lane,555-7282,621-12-1234,12.0
Tom,2631 Main Blv,423-1155,524-332-6654,10.0
Kristen,443 Norfolk str,765-9457,010-332-1111,20.0
Sam,999 Duplicate Line,999-9999,999-00-0000,2423.07
*/

public class main {
	public static void main(String[] args) {
	
		
        
		// Driver for Q2
        Integer[] integerArray = new Integer[] { 3, 2, 43, 55, 43, 21, 43, 55, 32, 22, 13, 4 };

        System.out.println("Integer array before sorting " + NumComp.printArray(integerArray));

        Arrays.sort(integerArray, new BinaryComparator());

        System.out.println("Integer array after sorting using binary Comparator :" + NumComp.printArray(integerArray));
        
        //Driver for Q1
        final String inputFile = "Employee.txt";
       
        
        DictApp app = new DictApp();
        app.getInput(inputFile);
        app.PrintDict1();
        app.PrintDict2();
        Dictionary<String, StaffMember> d1 = app.getDictionary1();
        Dictionary<String, StaffMember> d2 = app.getDictionary2();
        System.out.println("====================================");
        System.out.println("Finding by SSN :'621-12-1234'");
        StaffMember m = d1.find("621-12-1234");
        if(m != null){
            System.out.println(" 621-12-1234 is found");
            System.out.println(m);
        }
        else{
            System.out.println("621-12-1234 is not found");
        }
        System.out.println("====================================");
        System.out.println("Finding by SSN :'621-12-1434'");
        m = d1.find("621-12-1434");
        if(m != null){
            System.out.println(" 621-12-1434 is found");
            System.out.println(m);
        }
        else{
            System.out.println("621-12-1434 is not found");
        }
 }

}
class DictApp {//Q1
	   Dictionary<String, StaffMember> dictionary1 = new UALdictionary<String, StaffMember>(10);
	   Dictionary<String, StaffMember> dictionary2 = new UALdictionary<String, StaffMember>(10);
	  
	   public void getInput(String fileName){
	       try{
	           Scanner sc = new Scanner(new File(fileName));
	           while(sc.hasNext()){
	               String line = sc.nextLine();
	               String data[] = line.split(",");
	               if(data.length<5){
	                   System.out.println("Invalid Record");
	                   continue;
	               }
	               String name = data[0];
	               String address = data[1];
	               String phone = data[2];
	               String SocialSec = data[3];
	               Double Rate = Double.parseDouble(data[4]);
	               StaffMember member = new StaffMember();
	               member.SetStaffMember(name, address, phone, SocialSec, Rate);
	               dictionary1.insert(SocialSec, member);
	               dictionary2.insert(name, member);  
	           }
	          
	       }
	       catch(FileNotFoundException fnfe){
	           System.out.println("File Not Found");
	           fnfe.printStackTrace();
	       }
	   }
	   public void PrintDict1(){
	       System.out.println("================DICTIONARY 1====================");
	       for(int i=0;i<dictionary1.size();i++){
	           System.out.println("====================================");
	           StaffMember member = dictionary1.removeAny();
	           System.out.println(member);
	           dictionary1.insert(member.SocialSec, member);
	       }
	       System.out.println();
	   }
	   public void PrintDict2(){
	       System.out.println("================DICTIONARY 2====================");
	       for(int i=0;i<dictionary2.size();i++){
	           System.out.println("====================================");
	           StaffMember member = dictionary2.removeAny();
	           System.out.println(member);
	           dictionary2.insert(member.SocialSec, member);
	       }
	       System.out.println();
	   }
	   public Dictionary<String, StaffMember> getDictionary1(){
	       return dictionary1;
	   }
	   public Dictionary<String, StaffMember> getDictionary2(){
	       return dictionary2;
	   }
	   
	}

class NumComp{//Q2
	static String printArray(Integer[] anArray) {

        StringBuilder arrayString = new StringBuilder();

        arrayString.append("[");

        for (int i = 0; i < anArray.length; i++) {

               if (i > 0) {

                     arrayString.append(", ");

               }

               arrayString.append(anArray[i]);

        }

        arrayString.append("]");

        return arrayString.toString();

 }
}





// Reference files from moodle below; not modified





class BinaryComparator implements Comparator<Integer> {

 public int compare(Integer firstInteger, Integer secondInteger) {

        return (countOfOnesInBinary(firstInteger)).compareTo(countOfOnesInBinary(secondInteger));

 }

 private Integer countOfOnesInBinary(Integer integerValue) {

        String binaryString = Integer.toBinaryString(integerValue);

        Integer numberOfOnesInBinary = 0;

        for (Integer i = 0; i < binaryString.length(); i++) {

               if (binaryString.charAt(i) == '1') {

                     ++numberOfOnesInBinary;

               }

        }

        return numberOfOnesInBinary;

 }

}
	



//********************************************************************
//StaffMember.java     
//
//Represents a generic staff member.
//********************************************************************

class StaffMember
{
protected String name;
protected String address;
protected String phone;
protected String SocialSec;
protected Double Rate;

//-----------------------------------------------------------------
//  Constructor: Sets up this staff member using the specified
//  information.
//-----------------------------------------------------------------
public StaffMember() {

}

  
public void SetStaffMember (String eName, String eAddress, String ePhone, String eSocialSec, Double eRate)
{
  name = eName;
  address = eAddress;
  phone = ePhone;
  SocialSec = eSocialSec;
  Rate = eRate;
}


//-----------------------------------------------------------------
//  Returns a string including the basic employee information.
//-----------------------------------------------------------------
public String toString()
{
  String result = "Name: " + name + "\n";

  result += "Address: " + address + "\n";
  result += "Phone: " + phone + "\n";
  result += "Social Security # "+SocialSec;

  return result;
}

//-----------------------------------------------------------------
//  Derived classes must define the pay method for each type of
//  employee.
//-----------------------------------------------------------------

}
// Break!!!!!!!!!!!


/** Source code example for "A Practical Introduction to Data
Structures and Algorithm Analysis, 3rd Edition (Java)" 
by Clifford A. Shaffer
Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Dictionary implemented by unsorted array-based list. */
class UALdictionary<Key, E> implements Dictionary<Key, E> {
private static final int defaultSize = 50; // Default size
private AList<KVpair<Key,E>> list;  // To store dictionary

/** Constructors */
UALdictionary() { this(defaultSize); }
UALdictionary(int sz)
{ list = new AList<KVpair<Key, E>>(sz); }

/** Reinitialize */
public void clear() { list.clear(); }

/** Insert an element: append to list */
public void insert(Key k, E e) {
KVpair<Key,E> temp = new KVpair<Key,E>(k, e);
list.append(temp);
}

/** Use sequential search to find the element to remove */
public E remove(Key k) {
E temp = find(k);
if (temp != null) list.remove();
return temp;
}

/** Remove the last element */
public E removeAny() {
if (size() != 0) {
  list.moveToEnd();
  list.prev();
  KVpair<Key,E> e = list.remove();
  return e.value();
}
else return null;
}

/** Find k using sequential search
  @return Record with key value k */
public E find(Key k) {

for(list.moveToStart(); list.currPos() < list.length(); list.next())
 {
  KVpair<Key,E> temp = list.getValue();
  if (k.equals(temp.key()))
    return temp.value(); 
}
return null; // "k" does not appear in dictionary
}
/** @return List size */
public int size()
{ return list.length(); }

public String toString()
{
// Save the current position of the list
int length = list.length();
StringBuffer out = new StringBuffer((length + 1) * 4);

out.append("< ");
for(list.moveToStart(); list.currPos() < list.length();
    list.next()) {

  out.append(list.getValue().key());
  out.append(", ");
  //next();
 }
//  }
out.append(">");
//moveToPos(oldPos); // Reset the fence to its original position
return out.toString();
}

}
// Break!!!!!!!!!!!!!


/** Source code example for "A Practical Introduction to Data
Structures and Algorithm Analysis, 3rd Edition (Java)" 
by Clifford A. Shaffer
Copyright 2008-2011 by Clifford A. Shaffer
*/

/** The Dictionary abstract class. */
interface Dictionary<Key, E> {

/** Reinitialize dictionary */
public void clear();

/** Insert a record
  @param k The key for the record being inserted.
  @param e The record being inserted. */
public void insert(Key k, E e);

/** Remove and return a record.
  @param k The key of the record to be removed.
  @return A maching record. If multiple records match
  "k", remove an arbitrary one. Return null if no record
  with key "k" exists. */
public E remove(Key k);

/** Remove and return an arbitrary record from dictionary.
  @return the record removed, or null if none exists. */
public E removeAny();

/** @return A record matching "k" (null if none exists).
  If multiple records match, return an arbitrary one.
  @param k The key of the record to find */
public E find(Key k);

/** @return The number of records in the dictionary. */
public int size();
};
// Break!!!!!!

/** Source code example for "A Practical Introduction to Data
Structures and Algorithm Analysis, 3rd Edition (Java)" 
by Clifford A. Shaffer
Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Container class for a key-value pair */
class KVpair<Key, E> {
private Key k;
private E e;

/** Constructors */
KVpair()
{ k = null; e = null; }
KVpair(Key kval, E eval)
{ k = kval; e = eval; }

/** Data member access functions */
public Key key() { return k; }
public E value() { return e; }
}
// Break!!!!!!!!!!


/** Source code example for "A Practical Introduction to Data
Structures and Algorithm Analysis, 3rd Edition (Java)" 
by Clifford A. Shaffer
Copyright 2008-2011 by Clifford A. Shaffer
*/

/** List ADT */
interface List<E> {
/** Remove all contents from the list, so it is once again
  empty. Client is responsible for reclaiming storage
  used by the list elements. */
public void clear();

/** Insert an element at the current location. The client
  must ensure that the list's capacity is not exceeded.   
  @param item The element to be inserted. */
public void insert(E item);

/** Append an element at the end of the list. The client
  must ensure that the list's capacity is not exceeded.   
  @param item The element to be appended. */
public void append(E item);

/** Remove and return the current element.
  @return The element that was removed. */
public E remove();

/** Set the current position to the start of the list */
public void moveToStart();

/** Set the current position to the end of the list */
public void moveToEnd();

/** Move the current position one step left. No change
  if already at beginning. */
public void prev();

/** Move the current position one step right. No change
  if already at end. */
public void next();

/** @return The number of elements in the list. */
public int length();

/** @return The position of the current element. */
public int currPos();

/** Set current position.
  @param pos The position to make current. */
public void moveToPos(int pos);

/** @return The current element. */
public E getValue();
}
/** Source code example for "A Practical Introduction to Data
Structures and Algorithm Analysis, 3rd Edition (Java)" 
by Clifford A. Shaffer
Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Array-based list implementation */
class AList<E> implements List<E> {
private static final int defaultSize = 10; // Default size
private int maxSize;        // Maximum size of list
private int listSize;       // Current # of list items
private int curr;           // Position of current element
private E[] listArray;      // Array holding list elements

/** Constructors */
/** Create a list with the default capacity. */
AList() { this(defaultSize); }
/** Create a new list object.
  @param size Max # of elements list can contain. */
@SuppressWarnings("unchecked") // Generic array allocation
AList(int size) { 
maxSize = size;
listSize = curr = 0;
listArray = (E[])new Object[size];  // Create listArray
}

public void clear()         // Reinitialize the list
{ listSize = curr = 0; }  // Simply reinitialize values

/** Insert "it" at current position */
public void insert(E it) {
assert listSize < maxSize : "List capacity exceeded";
for (int i=listSize; i>curr; i--) // Shift elements up
  listArray[i] = listArray[i-1];  //   to make room
listArray[curr] = it;
listSize++;               // Increment list size
}

/** Append "it" to list */
public void append(E it) {
assert listSize < maxSize : "List capacity exceeded";
listArray[listSize++] = it;
}

/** Remove and return the current element */
public E remove() {
if ((curr<0) || (curr>=listSize))  // No current element
  return null;
E it = listArray[curr];   // Copy the element
for(int i=curr; i<listSize-1; i++) // Shift them down
  listArray[i] = listArray[i+1];
listSize--;               // Decrement size
return it;
}
public void moveToStart() { curr = 0; } // Set to front
public void moveToEnd() { curr = listSize; } // Set at end
public void prev() { if (curr != 0) curr--; }   // Back up
public void next() { if (curr < listSize) curr++; }

/** @return List size */
public int length() { return listSize; }

/** @return Current position */
public int currPos() { return curr; }

/** Set current list position to "pos" */
public void moveToPos(int pos) {
assert (pos>=0) && (pos<=listSize) : "Pos out of range";
curr = pos;
}

/** @return Current element */
public E getValue() {
assert (curr>=0) && (curr<listSize) :
       "No current element";
return listArray[curr];
}
//Extra stuff not printed in the book.

/**
* Generate a human-readable representation of this list's contents
* that looks something like this: < 1 2 3 | 4 5 6 >.  The vertical
* bar represents the current location of the fence.  This method
* uses toString() on the individual elements.
* @return The string representation of this list
*/
public String toString()
{
// Save the current position of the list
int oldPos = currPos();
int length = length();
StringBuffer out = new StringBuffer((length() + 1) * 4);

moveToStart();
out.append("< ");
for (int i = 0; i < oldPos; i++) {
  out.append(getValue());
  out.append(" ");
  next();
}
out.append("| ");
for (int i = oldPos; i < length; i++) {
  out.append(getValue());
  out.append(" ");
  next();
}
out.append(">");
moveToPos(oldPos); // Reset the fence to its original position
return out.toString();
}
}
