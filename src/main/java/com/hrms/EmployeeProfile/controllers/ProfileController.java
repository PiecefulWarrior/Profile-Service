package com.hrms.EmployeeProfile.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.EmployeeProfile.dao.Profile;
import com.hrms.EmployeeProfile.entities.ProfileData;
import com.hrms.EmployeeProfile.service.ProfileServiceImpl;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	public ProfileServiceImpl profileServiceImpl;
	
	// add Employee profiles
	@PostMapping("/addEmp")
	public ResponseEntity<ProfileData> addEmpData(@RequestBody ProfileData profileData) {
		
		return profileServiceImpl.addEmployeeProfile(profileData);
	}
	
	
	// fetch APIs for Employee Profiles 
	@GetMapping("/getEmp")
	public List<Profile> fetchAllProfiles() {
		
		return profileServiceImpl.getListOfAllProfiles();
		
	}
	
	@GetMapping("/getEmp/{id}")
	public Profile getProfileByID(@PathVariable("id") int id){
		
		return profileServiceImpl.getEmpProfileByID(id);
	}
	
	
	// Update APIs for Employee Profiles
	@PutMapping("/updateEmp/{id}")
	public ProfileData updateEmpData(@PathVariable("id") int id, @RequestBody ProfileData profileData) {
		
		return profileServiceImpl.updateEmployeeProfile(id, profileData);
		
	}
	
	//Delete APIs for Employee Profiles
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<ProfileData> deleteEmp(@PathVariable("id") int id) {
		
		return profileServiceImpl.deleteEmployeeProfile(id);
	}
	
	
}
