package com.hrms.EmployeeProfile.interfaces;

import java.util.List;

import com.hrms.EmployeeProfile.dao.Profile;
import com.hrms.EmployeeProfile.entities.ProfileData;

public interface ProfileServiceInterface {
	
	ProfileData getEmpProfileByID(int id);
	
	List<Profile> getListOfAllProfiles();
	
	ProfileData updateEmployeeProfile(int id, ProfileData profileData);
	
	ProfileData deleteEmployeeProfile(int id);
	
	ProfileData addEmployeeProfile(ProfileData profileData);

	
	
	

}
