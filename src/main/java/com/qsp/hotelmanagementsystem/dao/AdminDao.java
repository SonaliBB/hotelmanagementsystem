package com.qsp.hotelmanagementsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hotelmanagementsystem.dto.Admin;
import com.qsp.hotelmanagementsystem.repository.AdminRepo;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepo adminRepo;
	
	public  Admin saveAdmin(Admin admin) {
		return adminRepo.save(admin);
		
	}
	
	public  Admin updateAdmin(Admin admin) {
		return adminRepo.save(admin);	
	}
	
	public  Admin deleteAdmin(Admin admin) {
		adminRepo.delete(admin);
		return admin;
	}
	
	public Admin getAdminById(int aid) {
		if (adminRepo.findById(aid).isPresent()) {
			return adminRepo.findById(aid).get();
		}
		return null;
	}
	
	public List<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}
	
	public Admin getAdminByEmail(String email) {
		if (adminRepo.getAdminByEmail(email)!=null) {
			return adminRepo.getAdminByEmail(email);
		}
		return null;
	}
	
}
