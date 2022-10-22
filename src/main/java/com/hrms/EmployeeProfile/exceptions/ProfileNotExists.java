package com.hrms.EmployeeProfile.exceptions;

public class ProfileNotExists extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;

	public ProfileNotExists(String message) {
		super();
		this.message = message;
	}
	
	
	
	

}
