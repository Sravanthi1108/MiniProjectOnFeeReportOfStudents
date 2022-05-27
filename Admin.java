package feereport;

import java.io.Serializable;
import java.util.List;

public class Admin implements Serializable {
	String username;
	String password;
	String confirmpassword;
	String contactNo;
	public Admin(String username, String password, String confirmpassword, String contactNO) {
		super();
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.contactNo = contactNo;
	}
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + ", confirmpassword=" + confirmpassword
				+ ", contactNo=" + contactNo + "]";
	}
	
	}
	