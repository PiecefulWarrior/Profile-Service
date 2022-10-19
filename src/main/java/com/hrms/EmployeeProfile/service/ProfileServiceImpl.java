package com.hrms.EmployeeProfile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
	public List<ProfileData> getListOfAllProfiles() {
		
		List<ProfileData> allProfiles = profileRepo.findAll();
		return allProfiles;
	}

	@Override
	public ProfileData updateEmployeeProfile(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfileData deleteEmployeeProfile(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfileData addEmployeeProfile(ProfileData profileData) {
		// TODO Auto-generated method stub
		return null;
	}

}
