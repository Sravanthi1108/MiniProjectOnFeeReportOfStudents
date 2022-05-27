package feereport;

import java.io.Serializable;

public class Accountant implements Serializable {
	String id;
	String username;
	String password;
	String confirmpassword;
	String contactNo;
	public Accountant()
	{
		
	}
	public Accountant(String id,String username, String password, String confirmpassword, String contactNo) {
		//super();
		this.id=id;
		this.username = username;
		this.password = password;
	
		this.confirmpassword=confirmpassword;
		this.contactNo=contactNo;
				}
	@Override
	public String toString() {
		return "Accountant [id=" + id + ", username=" + username + ", password=" + password + ", confirmpassword="
				+ confirmpassword + ", contactNo=" + contactNo + "]";
	}
	
	   
	

	}