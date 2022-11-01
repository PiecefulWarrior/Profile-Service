package com.hrms.EmployeeProfile.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		
		ProfileData profile = profileServiceImpl.addEmployeeProfile(profileData);
		
		return new ResponseEntity<>(profile,HttpStatus.CREATED);
	}
	
	
	// fetch APIs for Employee Profiles 
	@GetMapping("/getEmp")
	public ResponseEntity<List<Profile>> fetchAllProfiles() {
		
		List<Profile> allProfiles = profileServiceImpl.getListOfAllProfiles();
		
		return new ResponseEntity<>(allProfiles,HttpStatus.OK);
		
	}
	
	@GetMapping("/getEmp/{id}")
	public ResponseEntity<Profile> getProfileByID(@PathVariable("id") int id){
		
		Profile profile = profileServiceImpl.getEmpProfileByID(id);
		
		return new ResponseEntity<>(profile,HttpStatus.OK);
	}
	
	
	// Update APIs for Employee Profiles
	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<ProfileData> updateEmpData(@PathVariable("id") int id, @RequestBody ProfileData profileData) {
		
		ProfileData profile = profileServiceImpl.updateEmployeeProfile(id, profileData);
		
		return new ResponseEntity<>(profile,HttpStatus.ACCEPTED);
		
	}
	
	//Delete APIs for Employee Profiles
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<ProfileData> deleteEmp(@PathVariable("id") int id) {
		
		ProfileData profile = profileServiceImpl.deleteEmployeeProfile(id);
		
		return new ResponseEntity<ProfileData>(profile,HttpStatus.OK);
	}
	
	@GetMapping("/getBydepartment/{dept}")
	public ResponseEntity<Profile> fetchWithDepartment(@PathVariable("dept") String dept){
		
		Profile profile = profileServiceImpl.findWithDepartment(dept);
		
		return new ResponseEntity<>(profile,HttpStatus.OK);
	}
	
	@GetMapping("/getByname/{name}")
	public ResponseEntity<Profile> fetchWithCity(@PathVariable("name") String name){
		
		Profile profile = profileServiceImpl.findWithName(name);
		
		return new ResponseEntity<>(profile,HttpStatus.OK);
	}
}
