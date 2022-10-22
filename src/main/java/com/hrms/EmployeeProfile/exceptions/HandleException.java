package com.hrms.EmployeeProfile.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {

		@ExceptionHandler(ProfileNotExists.class)
		public ResponseEntity<ErrorResponse> handleProfileNotExists(ProfileNotExists profileNotExists){
			
			ErrorResponse error = new ErrorResponse();
			error.setErrorMessage(profileNotExists.getMessage());
			error.setStatus(HttpStatus.NOT_FOUND.value());
			
			return ResponseEntity.ok(error);
		}
		
		@ExceptionHandler(ProfileAlreadyExists.class)
		public ResponseEntity<ErrorResponse> handleProfileAlreadyExists(ProfileAlreadyExists profileAlreadyExists){
			ErrorResponse error = new ErrorResponse();
			
			error.setErrorMessage(profileAlreadyExists.getMessage());
			error.setStatus(HttpStatus.ALREADY_REPORTED.value());
			return ResponseEntity.ok(error);
		}
	
}
