//Lab 6 Queues // Jaymee Hyppolite
import java.util.*;
import java.io.*;
//lab 6
public class main {
	public static void main(String[] args){

	String test = "abcd";
	System.out.println(Q1.SubString(test)); // Driver for Q1	
	
	
	
	
	
	
	}

}

class Q1{
	
	static boolean SubString(String x) {
		Queue<String> queue = new LinkedList<String>();
        String string=x;
        for (int i = 0; i < string.length(); i++) {
            for (int j = i+1; j <= string.length(); j++) {
                queue.add(string.substring(i,j));
            }
        }
        System.out.println(queue);
        return true;

    }
	
}


class Q2{

    public static void manageDictionary() throws IOException {

        Set<Employee> dict = new TreeSet<Employee>(); 
        BufferedReader br = null;

        try {

            String line;

            br = new BufferedReader(new FileReader("employee.txt"));  

            while ((line = br.readLine()) != null) {

                String split[] = line.split(","); 
                double sal = Double.parseDouble(split[4]);  
                Employee employee = new Employee(split[0],split[1],split[2],split[3],sal); 
                dict.add(employee);  
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("Enter employee name to search:");
        br = new BufferedReader(new InputStreamReader(System.in));  
        String name = br.readLine();

        boolean found = false;
        for(Employee employee : dict){    
            if(employee.getName().equalsIgnoreCase(name)){  
                System.out.println(employee);
                found = true;
                break;
            }
        }
        if(!found)  
            System.out.println("Employee not found");
	
	
	
}


class Employee implements Comparable{
    String name;
    String address;
    String mob;
    String ofcPhone;
    double salary;

    public Employee(String name, String address, String mob, String ofcPhone, double salary) {
        this.name = name;
        this.address = address;
        this.mob = mob;
        this.ofcPhone = ofcPhone;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mob='" + mob + '\'' +
                ", ofcPhone='" + ofcPhone + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getOfcPhone() {
        return ofcPhone;
    }

    public void setOfcPhone(String ofcPhone) {
        this.ofcPhone = ofcPhone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Object o) {    //employees in the dict should be sorted based on the name, thus implement compareTo based on employee name
        Employee emp = (Employee) o;
        return this.getName().compareTo(((Employee) o).getName());
    }
}

class CState {//CState.java

private String Prefix = new String();
private String Suffix = new String();
public CState (String Pre, String Suff)
{
 Prefix = Pre;
 Suffix = Suff;
}
public String pre()
{
 return Prefix;
}
public String suff()
{
  return Suffix;
 }
}
}

