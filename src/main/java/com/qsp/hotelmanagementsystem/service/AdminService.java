package com.qsp.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hotelmanagementsystem.dao.AdminDao;
import com.qsp.hotelmanagementsystem.dao.HotelDao;
import com.qsp.hotelmanagementsystem.dto.Admin;
import com.qsp.hotelmanagementsystem.dto.Customer;
import com.qsp.hotelmanagementsystem.dto.Hotel;
import com.qsp.hotelmanagementsystem.exception.IdNotFoundException;
import com.qsp.hotelmanagementsystem.util.ResponseStructure;

import net.bytebuddy.asm.Advice.Return;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	
	@Autowired
	private HotelDao hotelDao;
	ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin,int hid) {
		Hotel hotel=hotelDao.getHotelById(hid);
			admin.setHotel(hotel);
			Admin dbAdmin=adminDao.saveAdmin(admin);
			if (dbAdmin!=null) {
				responseStructure.setMessage("saved successfully");
				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setData(dbAdmin);
				return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.CREATED);
			
			}
			else {
				throw new IdNotFoundException();
			}
	}
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int aid,Admin admin) {
		Admin dbadmin=adminDao.getAdminById(aid);
		admin.setHotel(dbadmin.getHotel());
		if (dbadmin!=null) {
		admin.setAdmin_id(aid);
		responseStructure.setMessage("updated successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(adminDao.updateAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Admin>>  deleteAdmin(int aid) {
		Admin admin=adminDao.getAdminById(aid);
		if (admin!=null) {
			responseStructure.setMessage("deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(adminDao.deleteAdmin(admin));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);			
		}else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(String email) {
		Admin admin=adminDao.getAdminByEmail(email);
		if (admin!=null) {
			responseStructure.setMessage("fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.FOUND);

		}
		else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int aid) {
		Admin admin=adminDao.getAdminById(aid);
		if (admin!=null) {
			responseStructure.setMessage("fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.FOUND);

		}
		else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin() {
		ResponseStructure<List<Admin>> responseStructure=new  ResponseStructure<>();
		if (adminDao.getAllAdmin()!=null) {
			responseStructure.setMessage("fetched all data successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(adminDao.getAllAdmin());
			return new ResponseEntity<ResponseStructure<List<Admin>>>(responseStructure,HttpStatus.FOUND);

		}
		else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Admin>>  loginAdmin(String email,String password) {
		Admin admin=adminDao.getAdminByEmail(email);
		if (admin.getAdmin_password().equals(password)) {
			responseStructure.setMessage("fetched all data successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setMessage("Enter the valid email and password");
			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.BAD_REQUEST);
		
		}
	}
}
