package com.hrms.EmployeeProfile.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="profile_data")

public class ProfileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column
	String name;
	
	@Column
	String gender;
	
	@OneToOne
	Account account;
	
	@OneToMany
	List<Address> address;
	
	@OneToOne
	Department department;
	
	
	public ProfileData() {
		super();
	}





	public ProfileData(int id, String name, String gender, Account account, List<Address> address,
			Department department) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.account = account;
		this.address = address;
		this.department = department;
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





	public Account getAccount() {
		return account;
	}





	public void setAccount(Account account) {
		this.account = account;
	}





	public List<Address> getAddress() {
		return address;
	}





	public void setAddress(List<Address> address) {
		this.address = address;
	}





	public Department getDepartment() {
		return department;
	}





	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	

}
