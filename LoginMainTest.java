package feereport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class LoginMainTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		char aaoption, bboption, opion;

		Admin admin = new Admin();
		 Accountant accountant= new Accountant();
		LoginMainTest loginmaintest = new LoginMainTest();
		do {

			System.out.println("***********");
			System.out.println("**Fee Report Of Students**");
			System.out.println("***********");
			System.out.println("A:Admin");
			System.out.println("B:Accountant");
			System.out.println("Enter the option");
			Scanner scanner = new Scanner(System.in);
			char option = scanner.next().charAt(0);

			switch (option) {
			case 'A':
				do {

					System.out.println("---1.SIGNUP----");
					System.out.println("---2.LOGIN----");
					int choice = scanner.nextInt();
					File file = new File("User.txt");
					ArrayList<Admin> list = new ArrayList<Admin>();
					ObjectOutputStream out = null;
					ListIterator<Admin> iterator = null;
					switch (choice) {

					case 1:
						System.out.println("----------signup------------");
						System.out.println("Enter the Details");
						System.out.println("Enter the contact NO");
						String contactNo = scanner.next();
						System.out.println("Enter the username");
						String username = scanner.next();
						if (UserNameValidation.userNameValidation(username)) {
							System.out.println("valid username");
							System.out.println("Enter the Password");
							String password = scanner.next();
							if (PasswordValidation.passWordValidation(password)) {
								System.out.println("valid password");
								System.out.println("Enter the confirmpassword");
								String confirmpassword = scanner.next();
								if (password.equals(confirmpassword)) {
									list.add(new Admin(username, password, confirmpassword, contactNo));
									out = new ObjectOutputStream(new FileOutputStream(file));
									out.writeObject(list);
									out.close();
									System.out.println("Access Granted!you can login and go ahead");
								} else
									System.out.println("password doesnot match");
							} else
								System.out.println("password should be strong");
						} else
							System.out.println("enter the username again");
						break;
					case 2:
						System.out.println("------Login---------");
						System.out.println("enter the username");
						String username1 = scanner.next();
						System.out.println("enter the password");
						String Password1 = scanner.next();
						do {
							ObjectInputStream in = null;

							in = new ObjectInputStream(new FileInputStream(file));

							list = (ArrayList<Admin>) in.readObject();

							in.close();

							iterator = list.listIterator();
							while (iterator.hasNext()) {
								admin= (Admin) iterator.next();
							}
							if (username1.equals(admin.username)
									&& Password1.equals(admin.password)) {
								System.out.println("Login Success");
								if (admin.equals(admin)) {
									AdminOperations1.operations();
									
								}

							}
							break;
						} while (admin!= null);
					}
					System.out.println("do you wish to continue then press y if not press n");
					aaoption = scanner.next().charAt(0);
				} while (aaoption == 'Y' || aaoption == 'y');
				break;
			case 'B':
				do {

					System.out.println("---1.SIGNUP----");
					System.out.println("---2.LOGIN----");
					int choice = scanner.nextInt();
					File file = new File("User1.txt");
					ArrayList<Accountant> list = new ArrayList<Accountant>();
					ObjectOutputStream out = null;
					ListIterator<Accountant> iterator = null;
					switch (choice) {

					case 1:
						System.out.println("----------signup------------");
						System.out.println("Enter the Details");
						System.out.println("Enter the id");
						String id = scanner.next();
						System.out.println("Enter the contact no");
						String contactNo = scanner.next();
						System.out.println("Enter the username");
						String username = scanner.next();
						if (UserNameValidation.userNameValidation(username)) {
							System.out.println("valid username");
							System.out.println("Enter the Password");
							String password = scanner.next();
							if (PasswordValidation.passWordValidation(password)) {
								System.out.println("valid password");
								System.out.println("Enter the confirmpassword");
								String confirmpassword = scanner.next();
								if (password.equals(confirmpassword)) {
									list.add(new Accountant(id,username, password, confirmpassword, contactNo));

									out = new ObjectOutputStream(new FileOutputStream(file));

									out.writeObject(list);

									out.close();

									System.out.println("Access Granted!you can login and go ahead");
								} else
									System.out.println("password doesnot match");
							} else
								System.out.println("password should be strong");
						} else
							System.out.println("enter the username again");
						break;
					case 2:
						System.out.println("------Login---------");
						System.out.println("enter the username");
						String username1 = scanner.next();
						System.out.println("enter the password");
						String Password1 = scanner.next();
						do {
							ObjectInputStream in = null;

							in = new ObjectInputStream(new FileInputStream(file));

							list = (ArrayList<Accountant>) in.readObject();

							in.close();

							iterator = list.listIterator();
							while (iterator.hasNext()) {
								accountant = (Accountant) iterator.next();
							}
							if (username1.equals(accountant.username)
									&& Password1.equals(accountant.password)) {
								System.out.println("Login Success");
								if (accountant.equals(accountant)) {
									 AccountantOpearations1.operations();
								}

							}
							break;
						} while (accountant != null);
					}
					System.out.println("do you wish to continue then press y if not press n");
					bboption = scanner.next().charAt(0);
				} while (bboption == 'Y' || bboption == 'y');

			}
			System.out.println("do you wish to continue then press y if not press n");
			opion = scanner.next().charAt(0);
		} while (opion == 'Y' || opion == 'y');
	}


	}


