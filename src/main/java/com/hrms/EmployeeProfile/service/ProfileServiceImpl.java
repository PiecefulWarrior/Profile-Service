package com.hrms.EmployeeProfile.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public Profile getEmpProfileByID(int id) {
		
		ProfileData profileData = profileRepo.findById(id)
								  .orElseThrow(()->new ProfileNotExists("Data not availble for id :"+id));
		
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
								.orElseThrow(()->new ProfileNotExists("Data not availble for id :"+id));
		
		profile.setId(id);
		profile.setGender(profileData.getGender());
		profile.setName(profileData.getName());
		
		return profile;
	}

	@Override
	public ResponseEntity<ProfileData> deleteEmployeeProfile(int id) {
		
		ProfileData profileData = profileRepo.findById(id)
									.orElseThrow(()->new ProfileNotExists("Data not availble for id :"+id));
		profileRepo.deleteById(id);
		// TODO Auto-generated method stub
		return ResponseEntity.ok(profileData);
	}

	@Override
	public ResponseEntity<ProfileData> addEmployeeProfile(ProfileData profileData) {
		
		ProfileData profile = profileRepo.save(profileData);
		if(profile != null) {
		return  ResponseEntity.ok(profile);
			
		} 
			
		
		return new ResponseEntity<>(profileData,HttpStatus.BAD_REQUEST);
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
