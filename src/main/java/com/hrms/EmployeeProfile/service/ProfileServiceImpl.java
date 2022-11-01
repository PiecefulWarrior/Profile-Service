package com.hrms.EmployeeProfile.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hrms.EmployeeProfile.dao.Profile;
import com.hrms.EmployeeProfile.entities.ProfileData;
import com.hrms.EmployeeProfile.exceptions.ProfileNotExists;
import com.hrms.EmployeeProfile.interfaces.ProfileServiceInterface;
import com.hrms.EmployeeProfile.repositories.ProfileRepo;


@Service
public class ProfileServiceImpl implements ProfileServiceInterface{
	
	@Autowired
	ProfileRepo profileRepo;
	
	@Value("${exception.profilenotexists}") 
	String notFound;
	
	@Value("${exception.profilealreadyexists}") 
	String alreadyAvailable;
	

	@Override
	public Profile getEmpProfileByID(int id) {
		
		ProfileData profileData = profileRepo.findById(id)
								  .orElseThrow(()->new ProfileNotExists(notFound+id));
		
		Profile profile = this.convertToDto(profileData);
		
		return profile;
	}

	@Override
	public List<Profile> getListOfAllProfiles() {
		//
		//List<ProfileData> allProfiles = profileRepo.findAll();
		return profileRepo.findAll()
				.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}

	@Override
	public ProfileData updateEmployeeProfile(int id, ProfileData profileData) {
		ProfileData profile = profileRepo.findById(id)
								.orElseThrow(()->new ProfileNotExists(notFound+id));
		
		profile.setId(id);
		profile.setGender(profileData.getGender());
		profile.setName(profileData.getName());
		
		return profile;
	}

	@Override
	public ProfileData deleteEmployeeProfile(int id) {
		
		ProfileData profileData = profileRepo.findById(id)
									.orElseThrow(()->new ProfileNotExists(notFound+id));
		profileRepo.deleteById(id);
		// TODO Auto-generated method stub
		return profileData;
	}

	@Override
	public ProfileData addEmployeeProfile(ProfileData profileData) {
		
		ProfileData profile = profileRepo.save(profileData);
		
			
		
		return profile;
	}
	
	public Profile findWithDepartment(String dept) {
		
		ProfileData profileData = profileRepo.findByDepartment(dept);
		
		return this.convertToDto(profileData);
		
	}
	
	public Profile findWithName(String name) {
		
		ProfileData profileData = profileRepo.findByName(name);
		
		return this.convertToDto(profileData);
		
	}
	public Profile convertToDto(ProfileData profileData) {
		
		Profile profile = new Profile();
		
		
		profile.setId(profileData.getId());
		profile.setName(profileData.getName());
		profile.setGender(profileData.getGender());
		profile.setDept(profileData.getDepartment().getDept());
		profile.setAcct_Type(profileData.getAccount().getType());
		profile.setAccount(profileData.getAccount().getAccountNo());
		profile.setAddress(profileData.getAddress());
		
		return profile;
	}
	

}
