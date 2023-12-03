package com.qsp.hotelmanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hotelmanagementsystem.dto.Admin;
import com.qsp.hotelmanagementsystem.service.AdminService;
import com.qsp.hotelmanagementsystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@RequestMapping("/admin")
public class AdminController {
@Autowired
private AdminService adminService;

@ApiOperation(value = "save Admin ",notes = "api is used to save Admin ")
@ApiResponses(value = {@ApiResponse(code = 201,message = " Admin details saved successfully"),@ApiResponse(code = 404,message = "Admin not saved, enter the valid details")})

@PostMapping
public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@Valid @RequestBody Admin admin,@RequestParam int hid) {
	return adminService.saveAdmin(admin, hid);

}

@ApiOperation(value = "update Admin ",notes = "api is used to updated Admin ")
@ApiResponses(value = {@ApiResponse(code = 200,message = " Admin details updated successfully"),@ApiResponse(code = 404,message = "Admin not updated, enter the valid details")})
@PutMapping
public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@Valid @RequestBody Admin admin,@RequestParam int aid) {
	return adminService.updateAdmin(aid, admin);
	
}

@ApiOperation(value = "delete Admin ",notes = "api is used to delete Admin ")
@ApiResponses(value = {@ApiResponse(code = 200,message = " Admin details deleted successfully"),@ApiResponse(code = 404,message = "Admin not deleted, enter the valid details")})
@DeleteMapping
public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@Valid @RequestParam int aid) {
	return adminService.deleteAdmin(aid);
}

@ApiOperation(value = "get Admin by id",notes = "api is used to get Admin by id")
@ApiResponses(value = {@ApiResponse(code =302,message = " Admin details fetched successfully"),@ApiResponse(code = 404,message = "Admin not found, enter the valid details")})
@GetMapping
public ResponseEntity<ResponseStructure<Admin>> getAdminById(@Valid @RequestParam int aid) {
	return adminService.getAdminById(aid);
	
}

@ApiOperation(value = "get Admin by Email",notes = "api is used to get Admin by Email")
@ApiResponses(value = {@ApiResponse(code =302,message = " Admin details fetched successfully"),@ApiResponse(code = 404,message = "Admin not found, enter the valid details")})
@GetMapping("/gettheadminbyemail")
public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(@Valid @RequestParam String email) {
	return adminService.getAdminByEmail(email);
	
}

@ApiOperation(value = "get All Admin",notes = "api is used to get all Admin")
@ApiResponses(value = {@ApiResponse(code = 302,message = " Admin details fetched successfully"),@ApiResponse(code = 404,message = "Admin not found, enter the valid details")})
@GetMapping("/getalladmin")
public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin() {
	return adminService.getAllAdmin();

}

@ApiOperation(value = "Login Admin",notes = "api is used to login Admin")
@ApiResponses(value = {@ApiResponse(code = 302,message = " Admin login fetched successfully"),@ApiResponse(code = 404,message = "Admin not found, enter the valid details")})
@GetMapping("/loginadmin")
public ResponseEntity<ResponseStructure<Admin>> loginAdmin(@Valid @RequestParam String email,@RequestParam String password) {
	return adminService.loginAdmin(email, password);
}

}





