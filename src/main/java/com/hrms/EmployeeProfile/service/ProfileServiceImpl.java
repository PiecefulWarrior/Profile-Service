package com.hrms.EmployeeProfile.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.hrms.EmployeeProfile.dao.Profile;
import com.hrms.EmployeeProfile.entities.ProfileData;
import com.hrms.EmployeeProfile.interfaces.ProfileServiceInterface;
import com.hrms.EmployeeProfile.repositories.ProfileRepo;

public class ProfileServiceImpl implements ProfileServiceInterface{
	
	@Autowired
	ProfileRepo profileRepo;

	@Override
	public ProfileData getEmpProfileByID(int id) {
		
		profileRepo.findById(id);
		
		return null;
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
		ProfileData profile = profileRepo.findById(id).orElse( new ProfileData());
		
		profile.setId(id);
		profile.setGender(profileData.getGender());
		profile.setName(profileData.getName());
		
		return null;
	}

	@Override
	public ProfileData deleteEmployeeProfile(int id) {
		
		ProfileData profileData = profileRepo.findById(id).orElse(null);
		profileRepo.deleteById(id);
		// TODO Auto-generated method stub
		return profileData;
	}

	@Override
	public ProfileData addEmployeeProfile(ProfileData profileData) {
		
		ProfileData profile = profileRepo.save(profileData);
		
		return profile;
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
