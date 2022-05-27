package feereport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class AdminOperations1 {
	
	public static void operations() throws IOException, ClassNotFoundException
	{
		String id;
		String username;
		String password;
		String confirmpassword;
		String contactNo;
	
	
	
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		ArrayList<Accountant> list = new ArrayList<Accountant>();
		File file = new File("AccountantDetails.txt");// initialising file object and passing filename as argument
		ObjectOutputStream out = null;// initially writing the object as null
		ObjectInputStream in = null;
		ListIterator<Accountant> iterator = null;
		File file1 = new File("AccountantDetails.txt");
		Accountant accountant = new Accountant();
		ArrayList<Accountant> list1 = new ArrayList<Accountant>();
		ObjectOutputStream out1 = null;
		ObjectInputStream in1 = null;
		ListIterator<Accountant> iterator1 = null;
		char ch;
		do {
			System.out.println("==================");
			System.out.println("== HELLO ADMIN ==");
			System.out.println("==================");
			System.out.println("1. Add Accountant");
			System.out.println("2. view All Accountant ");
			System.out.println("3. Delete Accounatants ");
			System.out.println("4. Exit");
			
			System.out.println("==================");
			System.out.println();
			System.out.println("Enter your choice ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Welcome Admin!");
	 	 		System.out.println("Please Enter the no of  accountants that you want to add");
				int no_of_accountants = scanner.nextInt();
				for (int i = 0; i < no_of_accountants; i++) {
					System.out.println("Enter the id");
					id = scanner1.nextLine();
					System.out.println("Enter the username");
					username = scanner1.nextLine();
					System.out.println("Enter password");
					password = scanner1.nextLine();
					System.out.println("Enter the confirm password");
					confirmpassword = scanner1.nextLine();
					System.out.println("Enter contactNo");
					contactNo= scanner1.nextLine();
					
					// adding accountant properties object to list
					list.add(new Accountant(id,username,password,confirmpassword,contactNo));
				}
				// fileoutputstream writes the file and it will be used by
				// objectoutputstream
				out = new ObjectOutputStream(new FileOutputStream(file));
           	out.writeObject(list);// writes the object available in list into the file.
				out.close();
				break;
			case 2:
				System.out.println("---View All Accountants--");
				in = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<Accountant>) in.readObject();
				in.close();
				iterator = list.listIterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
				break;
			
			  case 3: 
				  System.out.println("-------Delete  Accounatants --------"); 
			  boolean found1 = false; 
			  System.out.println("Enter the id to be removed"); 
			  String id_delete = scanner1.nextLine(); 
			  in = new ObjectInputStream(new FileInputStream(file)); 
			  list = (ArrayList<Accountant>) in.readObject();
			  in.close(); 
			  iterator = list.listIterator(); 
			  while (iterator.hasNext()) 
			  {
				  Accountant accountantl = ( Accountant) iterator.next(); 
				  if(accountantl.id.equals(id_delete)) 
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
		