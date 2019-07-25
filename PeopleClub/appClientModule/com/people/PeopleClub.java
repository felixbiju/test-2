package com.people;

import java.sql.Date;

public class PeopleClub {
	 int pid;
	String fname;
	String lname;
	Date dob;
	String city;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public PeopleClub(String city) {
		super();
		this.city = city;
	}
	public PeopleClub(int pid, String fname, String lname, Date dob, String city) {
		super();
		this.pid = pid;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.city = city;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public PeopleClub(String fname, String lname, Date dob, String city) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.city = city;
	}
	@Override
	public String toString() {
		return "PeopleClub [pid=" + pid + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", city=" + city
				+ "]";
	}
	

	
	
	
	

}
