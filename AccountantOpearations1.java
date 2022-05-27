package feereport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class AccountantOpearations1 {
	public static void operations() throws IOException, ClassNotFoundException
	{
		String id;
		String name;
		String course;
		String contactNo;
		String location;
		String fee;
		String paidAmt;
		String dueAmt;
	
	
	
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<Student>();
		File file = new File("StudentDetails.txt");// initialising file object and passing filename as argument
		ObjectOutputStream out = null;// initially writing the object as null
		ObjectInputStream in = null;
		ListIterator<Student> iterator = null;
		File file1 = new File("StudentDetails.txt");
		Student student = new Student();
		ArrayList<Student> list1 = new ArrayList<Student>();
		ObjectOutputStream out1 = null;
		ObjectInputStream in1 = null;
		ListIterator<Student> iterator1 = null;
		char ch;
		do {
			System.out.println("==================");
			System.out.println("== HELLO ACCOUNTANT ==");
			System.out.println("==================");
			System.out.println("1. Add Student");
			System.out.println("2. view All Students ");
			System.out.println("3. Delete students ");
			System.out.println("4. Exit");
			
			System.out.println("==================");
			System.out.println();
			System.out.println("Enter your choice ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Welcome Accountant!");
	 	 		System.out.println("Please Enter the no of  students that you want to add");
				int no_of_students = scanner.nextInt();
				for (int i = 0; i < no_of_students; i++)
				{
					System.out.println("Enter the id");
					id = scanner1.nextLine();
					System.out.println("Enter the name");
					name = scanner1.nextLine();
					System.out.println("Enter course");
					course = scanner1.nextLine();
					System.out.println("Enter the contactNo");
					contactNo = scanner1.nextLine();
					System.out.println("Enter location");
					location= scanner1.nextLine();
					System.out.println("Enter fee");
					fee= scanner1.nextLine();
					System.out.println("Enter paidAmt");
					paidAmt= scanner1.nextLine();
					System.out.println("Enter dueAmt");
					dueAmt= scanner1.nextLine();
					
					// adding student properties object to list
					list.add(new Student(id,name,course,contactNo,location,fee,paidAmt,dueAmt));
				}
				// fileoutputstream writes the file and it will be used by
				// objectoutputstream
				out = new ObjectOutputStream(new FileOutputStream(file));
           	    out.writeObject(list);// writes the object available in list into the file.
				out.close();
				break;
			case 2:
				System.out.println("---View All Students--");
				in = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<Student>) in.readObject();
				in.close();
				iterator = list.listIterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
				break;
			
			  case 3: 
				  System.out.println("-------Delete  Students --------"); 
			  boolean found1 = false; 
			  System.out.println("Enter the id to be removed"); 
			  String id_delete = scanner1.nextLine(); 
			  in = new ObjectInputStream(new FileInputStream(file)); 
			  list = (ArrayList<Student>) in.readObject();
			  in.close(); 
			  iterator = list.listIterator(); 
			  while (iterator.hasNext()) 
			  {
				  Student pl = (Student) iterator.next(); 
				  if(pl.id.equals(id_delete)) 
				  { 
					  iterator.remove(); 
					  found1 = true; 
					  } 
				  }
			  if (found1) 
			  { 
				  out = new ObjectOutputStream(new FileOutputStream(file));
			  out.writeObject(list); out.close(); 
			  System.out.println(id_delete +" is removed sucessfully"); 
			  } else 
			  { 
				  System.out.println(id_delete +" is not in a list"); 
				  } 
			  break;
			  default: System.out.println("enter the valid option");
			  break;
			 
			case 4:
				
				System.exit(0);
			
				
				break;
			}
			System.out.println("Do u want to continue press y");
			ch = scanner.next().charAt(0);
		} while (ch == 'y');

	}
}



