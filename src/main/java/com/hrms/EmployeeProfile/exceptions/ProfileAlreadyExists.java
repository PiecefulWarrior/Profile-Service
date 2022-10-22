package com.hrms.EmployeeProfile.exceptions;

public class ProfileAlreadyExists extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	
	
	public ProfileAlreadyExists() {
		super();
	}



	public ProfileAlreadyExists(String message) {
		super();
		this.message = message;
	}
	
	

	
	
	

}
