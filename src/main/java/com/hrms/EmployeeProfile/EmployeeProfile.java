package com.hrms.EmployeeProfile;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:messeges.properties")
public class EmployeeProfile{
	
	
	public static void main(String[] args){
	
		SpringApplication.run(EmployeeProfile.class, args);
	}

	

}
