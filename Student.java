package feereport;

import java.io.Serializable;

public class Student implements Serializable{
	String id;
	String name;
	String course;
	String contactNo;
	String location;
	String fee;
	String paidAmt;
	String dueAmt;
	public Student()
	{
		
	}
	public Student(String id,String name, String course, String contactNo, String location, String fee, String paidAmt, String dueAmt) {
		super();
		this.id=id;
		this.name = name;
		this.course = course;
		this.contactNo = contactNo;
		this.location = location;
		this.fee = fee;
		this.paidAmt = paidAmt;
		this.dueAmt = dueAmt;
	}
	
	@Override
	public String toString() {
		return "Student [id="+id+",name=" + name + ", course=" + course + ", contactNo=" + contactNo + ", location=" + location
				+ ", fee=" + fee + ", paidAmt=" + paidAmt + ", dueAmt=" + dueAmt + "]";
	}
	

}
