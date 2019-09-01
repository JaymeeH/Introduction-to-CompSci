//Lab 1 inheritance
public class main {
	public static void main(String[] args){


		// test AboluteProgression

		 System.out.println("Absolute progression: ");
		 AbsoluteProgression prog = new AbsoluteProgression(10,400);
		 System.out.println("Prev "+ prog.prev);
		 /*ArithProgression Aprog = new ArithProgression();
		 Aprog.setInc(10);
		 for (int i = 0; i<10;i++) {
			 System.out.println("Next " + Aprog.nextValue());
		 }*/
		 GeomProgression Gprog = new GeomProgression();
		 Gprog.setBase(10);
		 for (int i = 0; i<10;i++) {
			 System.out.println("Next " + Gprog.nextValue());
		 }
		 

		}

}

class Progression{
	public int first;
	int cur;
	protected int firstValue() {
		cur = first;
		return cur;
	}
	protected int nextValue() {
		return ++ cur;
		
	}
	
	
}

class ArithProgression extends Progression{
	private int increment = 1;
	private int first = 0;
	private int cur = first;
	public void setInc(int x) {
		increment = x;
	}
	public int firstValue() {
		cur = first =0;
		return cur;
	}
	
	public int nextValue() {
		cur = cur + increment;
		
		return cur;
		
	}
	
	
}

class GeomProgression extends Progression{
	private int base = 2;
	private int first = 1;
	private int cur = first;
	public void setBase(int x) {
		base = x;
	}
	public int nextValue() {
		cur = cur * base;
		
		return cur;
	}
	
	
}

class AbsoluteProgression extends Progression {
	  protected long prev;
	  //default constructor
	  public AbsoluteProgression( ) { this(2,200); } //default constructor
	  public AbsoluteProgression(long first, long second) {
	  prev = Math.abs(first - second);
	 }

	}



class Person{
		 String name;
		String address;
		String number;
		String eAddress;
		public void SetInfo(String n, String a, String num, String Eadd) {
			name = n;
			address = a;
			number = num;
			eAddress = Eadd;
			
		}
	
}

class Student extends Person{
	private String Status;
	
	public String toString(){
		return Status;
		
		
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
}

class Employee extends Person{
	private int salary;
	private int officeNum;
	private String date;
	public void setEmp(int sal, int offNum) {
		salary = sal;
		officeNum = offNum;
	}
	public int getSalary() {
		return salary;
		
	}
	public int getOfficeNum() {
		return officeNum;
		
	}
	public void Date(String d) {
		 //date in the form mm/dd/yy

		
		this.date = d;
		

	}
	public String getDate(){
		return date;
		}

	}
	
	
	
	


class Faculty extends Employee{
	String officeHours;
	String Rank;
	public void setHoursandRank(String x, String y) {
		officeHours = x;
		Rank = y;
	}
	public String getHours() {
		return officeHours;
	}
	public String getRank() {
		return Rank;
	}
	public String toString(){
		return officeHours+Rank;
		
		
	}
	
	
}
class Staff extends Employee{
	String Title;
	public void setTitle(String T) {
		Title = T;
	}
	public String getTitle() {
		return Title;
	}
	public String toString(){
		return Title;
		
		
	}
	
}



