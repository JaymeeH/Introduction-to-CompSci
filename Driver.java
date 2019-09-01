// Lab 13 More Javafx / Jaymee Hyppolite

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Driver{
public static void main(String[] args){

long timeEnd, timeStart;
try {

File file = new File("inventory.txt");
Scanner scan = new Scanner(file);

ArrayList<String> data = new ArrayList<>();
while (scan.hasNext()) {

data.add(scan.nextLine());
}
scan.close();


String dataI[] = new String[1];
String dataQ[] = new String[1];
String dataM[] = new String[1];
dataI = data.toArray(dataI);
dataQ = data.toArray(dataQ);
dataM = data.toArray(dataM);


timeStart = System.nanoTime();
InsertionSort.Sort(dataI, dataI.length);
timeEnd = System.nanoTime();
System.out.println("Time took to sort with insertion sort:" + (timeEnd - timeStart));
System.out.println("Sorted content: ");
for (int i = 0; i < dataI.length; i++) {
System.out.print(dataQ[i] + " ");
}
System.out.println("\n\n");


timeStart = System.nanoTime();
QuickSort.Sort(dataQ);
timeEnd = System.nanoTime();
System.out.println("Time took to sort with quick sort:" + (timeEnd - timeStart));
System.out.println("Sorted content: ");
for (int i = 0; i < dataQ.length; i++) {
System.out.print(dataQ[i] + " ");
}
System.out.println("\n\n");


timeStart = System.nanoTime();
MergeSort.Sort(dataM);
timeEnd = System.nanoTime();
System.out.println("Time took to sort with merge sort:" + (timeEnd - timeStart));
System.out.println("Sorted content: ");
for (int i = 0; i < dataM.length; i++) {
System.out.print(dataM[i] + " ");
}
System.out.println();
  
} catch (FileNotFoundException ex) {
ex.printStackTrace();
}
//Q2
new FlowDemo();
}
}


import java.util.Comparator;
class SelectionSortS{
private SortNode list;

//-----------------------------------------------------------------
// Creates an initially empty linked list.
//-----------------------------------------------------------------
public SelectionSortS() {
list = null;
}
//-----------------------------------------------------------------
// Adds an integer to the linked list
//-----------------------------------------------------------------

public void add(String value) {
SortNode node = new SortNode(value);
SortNode current = null;
if (list == null) {
list = node;
} else {
current = list;
while (current.next != null) {
current = current.next;
}
current.next = node;
}
}

//-----------------------------------------------------------------
// Sorts the linked list using the selection sort.
//-----------------------------------------------------------------
public void sort() {
SortNode current = list;
SortNode min = list;
SortNode swapPos = list;

if (list == null) {
return;
}

while (swapPos.next != null) {
while (current.next != null) // find min value
{
current = current.next;
if (current.value.compareTo(min.value) < 0) {
min = current;
}
}
// Swap the values
if (min != swapPos) // a swap was found
{
String temp = min.value;
min.value = swapPos.value;
swapPos.value = temp;
}
swapPos = swapPos.next;
current = swapPos;
min = current;
}
}

//-----------------------------------------------------------------
// Returns a listing of the contents of the linked list.
//-----------------------------------------------------------------
public String toString() {
String report = "";
SortNode current = list;

if (current != null) {
report += String.valueOf(current.value) + " ";
while (current.next != null) {
current = current.next;
report += String.valueOf(current.value) + " ";
}
}
return report;
}


private class SortNode {

public String value;
public SortNode next;

public SortNode(String current) {
value = current;
next = null;
}
}
}

import java.io.*;
class QuickSort{
static int THRESHOLD = 0;
static int ARRAYSIZE = 0;

static <E extends Comparable<? super E>> void Sort(E[] A) {
qsort(A, 0, A.length - 1);
}
static int MAXSTACKSIZE = 1000;

static <E extends Comparable<? super E>>
void qsort(E[] A, int i, int j) { // Quicksort
int pivotindex = findpivot(A, i, j); // Pick a pivot
DSutil.swap(A, pivotindex, j); // Stick pivot at end
// k will be the first position in the right subarray
int k = partition(A, i - 1, j, A[j]);
DSutil.swap(A, k, j); // Put pivot in place
if ((k - i) > 1) {
qsort(A, i, k - 1); // Sort left partition
}
if ((j - k) > 1) {
qsort(A, k + 1, j); // Sort right partition
}
}

static <E extends Comparable<? super E>>
int partition(E[] A, int l, int r, E pivot) {
do { // Move bounds inward until they meet
while (A[++l].compareTo(pivot) < 0);
while ((r != 0) && (A[--r].compareTo(pivot) > 0));
DSutil.swap(A, l, r); // Swap out-of-place values
} while (l < r); // Stop when they cross
DSutil.swap(A, l, r); // Reverse last, wasted swap
return l; // Return first position in right partition
}

static <E extends Comparable<? super E>>
int findpivot(E[] A, int i, int j) {
return (i + j) / 2;
}

}

import java.io.*;
public class MergeSort {
static int THRESHOLD = 0;
static int ARRAYSIZE = 0;

@SuppressWarnings("unchecked") // Generic array allocation
static <E extends Comparable<? super E>> void Sort(E[] A) {
E[] temp = (E[]) new Comparable[A.length];
mergesort(A, temp, 0, A.length - 1);
}

static <E extends Comparable<? super E>>
void mergesort(E[] A, E[] temp, int l, int r) {
int mid = (l + r) / 2; // Select midpoint
if (l == r) {
return; // List has one element
}
mergesort(A, temp, l, mid); // Mergesort first half
mergesort(A, temp, mid + 1, r); // Mergesort second half
for (int i = l; i <= r; i++) // Copy subarray to temp
{
temp[i] = A[i];
}
// Do the merge operation back to A
int i1 = l;
int i2 = mid + 1;
for (int curr = l; curr <= r; curr++) {
if (i1 == mid + 1) // Left sublist exhausted
{
A[curr] = temp[i2++];
} else if (i2 > r) // Right sublist exhausted
{
A[curr] = temp[i1++];
} else if (temp[i1].compareTo(temp[i2]) < 0) // Get smaller
{
A[curr] = temp[i1++];
} else {
A[curr] = temp[i2++];
}
}
}
}

import java.io.*;
public class InsertionSort {
static int THRESHOLD = 0;
static int ARRAYSIZE = 0;

static <E extends Comparable<? super E>>
void Sort(E[] A, int l) {
for (int i = 1; i < l; i++) // Insert i'th record
{
for (int j = i; (j > 0) && (A[j].compareTo(A[j - 1]) < 0); j--) {
DSutil.swap(A, j, j - 1);
}
}
}

}


import java.util.*;
import java.math.*;
/** A bunch of utility functions. */
class DSutil<E> {

/**
* Swap two Objects in an array
*
* @param A The array
* @param p1 Index of one Object in A
* @param p2 Index of another Object A
*/
public static <E> void swap(E[] A, int p1, int p2) {
E temp = A[p1];
A[p1] = A[p2];
A[p2] = temp;
}

/**
* Randomly permute the Objects in an array.
*
* @param A The array
*/
// int version
// Randomly permute the values of array "A"
static void permute(int[] A) {
for (int i = A.length; i > 0; i--) // for each i
{
swap(A, i - 1, DSutil.random(i)); // swap A[i-1] with
}
} // a random element

public static void swap(int[] A, int p1, int p2) {
int temp = A[p1];
A[p1] = A[p2];
A[p2] = temp;
}

/**
* Randomly permute the values in array A
*/
static <E> void permute(E[] A) {
for (int i = A.length; i > 0; i--) // for each i
{
swap(A, i - 1, DSutil.random(i)); // swap A[i-1] with
}
} // a random element
/**
* Initialize the random variable
*/
static private Random value = new Random(); // Hold the Random class object

/**
* Create a random number function from the standard Java Random class. Turn
* it into a uniformly distributed value within the range 0 to n-1 by taking
* the value mod n.
*
* @param n The upper bound for the range.
* @return A value in the range 0 to n-1.
*/
static int random(int n) {
return Math.abs(value.nextInt()) % n;
}
}
package layout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class FlowDemo extends JFrame implements ActionListener {

   JButton b1,b2,b3;
   JLabel lbl;
   JTextField txt;
   int arr[]={4,6,2,1,9,45,67,34,23,89,107,234,0};
   public FlowDemo(){
      
       setSize(500, 500);
       setVisible(true);
       setLayout(new FlowLayout());
      
       b1=new JButton("Bubble Sort");
       b2=new JButton("Selection Sort");
       b3=new JButton("Insertion Sort");
      
       add(b1);
       add(b2);
       add(b3);
      
       b1.addActionListener(this);
       b2.addActionListener(this);
       b3.addActionListener(this);
       lbl=new JLabel("Time in nano seconds:");
       add(lbl);
      
       txt=new JTextField(20);
       add(txt);
   }
  
public void insertionSort(int arr[]){
      
       for(int i=1;i<arr.length;i++)
       {
           int j=i-1;
           int key=arr[i]; 
           while(j>-1 && arr[j]>key) 
           {
               arr[j+1]=arr[j];
               j--;
           }
          
           arr[j+1]=key; 
          
       }
   }

public void selectionSort(int arr[])
{
   for(int i=0;i<arr.length;i++)
   {
       int key=i;
      
       for(int j=i+1;j<arr.length;j++)
       {
           if(arr[j]<arr[key]) 
               key=j;
       }
      
       
       int temp=arr[key];
       arr[key]=arr[i];
       arr[i]=temp;
   }
}

public void QuickSort(int arr[]){
  
   for(int i=0;i<arr.length;i++){
       for(int j=i+1;j<arr.length;j++){
           if(arr[j]<arr[i]){
               int temp=arr[i];
               arr[i]=arr[j];
               arr[j]=arr[i];
           }
       }
   }
}
   public void actionPerformed(ActionEvent ae){
      
       JButton b=(JButton)ae.getSource();
      
       if(b.equals(b1)){
           long start=System.nanoTime();
           bubbleSort(arr);
           long end=System.nanoTime();
          
           long diff=end-start;
           txt.setText(""+diff);
       }
      
       else if(b.equals(b2)){
           long start=System.nanoTime();
           selectionSort(arr);
           long end=System.nanoTime();
          
           long diff=end-start;
           txt.setText(""+diff);
       }
      
       else if(b.equals(b3)){
           long start=System.nanoTime();
           insertionSort(arr);
           long end=System.nanoTime();
          
           long diff=end-start;
           txt.setText(""+diff);
       }
   }
  
  
}
