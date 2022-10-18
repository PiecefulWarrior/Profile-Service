package com.hrms.EmployeeProfile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.EmployeeProfile.entities.ProfileData;


@Repository
public interface ProfileRepo extends JpaRepository<ProfileData, Integer> {
	
	

}
