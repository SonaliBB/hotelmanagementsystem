package com.qsp.hotelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.hotelmanagementsystem.dto.Admin;


public interface AdminRepo extends JpaRepository<Admin,Integer> {

	@Query("select a from Admin a where a.admin_email=?1")
	public Admin getAdminByEmail(String admin_email);
	
	//public Admin getByEmail(String admin_email);
}
