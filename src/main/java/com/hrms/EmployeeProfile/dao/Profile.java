package com.hrms.EmployeeProfile.dao;

import java.util.List;

import com.hrms.EmployeeProfile.entities.Address;

public class Profile {
	
	int id;
	
	String name;
	
	String gender;
	
	String dept;
	
	String acct_Type;
	
	long account;
	
	List<Address> address;
	
	

	public Profile() {
		super();
	}

	
	
	
	public Profile(int id, String name, String gender, String dept, String acct_Type, long account,
			List<Address> address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dept = dept;
		this.acct_Type = acct_Type;
		this.account = account;
		this.address = address;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getAcct_Type() {
		return acct_Type;
	}

	public void setAcct_Type(String acct_Type) {
		this.acct_Type = acct_Type;
	}

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}


	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}

	

	
	
	
		
}
