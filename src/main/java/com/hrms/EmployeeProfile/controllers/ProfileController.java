package com.hrms.EmployeeProfile.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.EmployeeProfile.entities.ProfileData;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	// add Employee profiles
	@PostMapping("/addEmp")
	public ProfileData addEmpData(@RequestBody ProfileData profileData) {
		
		return new ProfileData();
	}
	
	
	// fetch APIs for Employee Profiles 
	@GetMapping("/getEmp")
	public List<ProfileData> fetchAllProfiles() {
		
		return null;
		
	}
	
	@GetMapping("/getEmp/{id}")
	public ProfileData getProfileByID(@PathVariable("id") int id){
		
		return null;
	}
	
	
	// Update APIs for Employee Profiles
	@PutMapping("/updateEmp/{id}")
	public ProfileData updateEmpData(@PathVariable("id") int id) {
		
		
		return null;
		
	}
	
	//Delete APIs for Employee Profiles
	
	@DeleteMapping("/deleteEmp/{id}")
	public ProfileData deleteEmp(@PathVariable("id") int id) {
		
		return null;
	}
	
	
}
