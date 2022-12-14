package com.hrms.EmployeeProfile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.EmployeeProfile.dao.Profile;
import com.hrms.EmployeeProfile.entities.ProfileData;


@Repository
public interface ProfileRepo extends JpaRepository<ProfileData, Integer> {
	
		ProfileData findByDepartment(String dept);
		ProfileData findByName(String name);
	//	Profile findByName(String name);
		
	//	Profile findByGender(String gender);
	//	Profile findByCountry(String country);
		
	//	Profile findByNameAndDepartment(String name, String dept);
	//	Profile findByGenderAndCity(String gender, String city);
	
	

}
