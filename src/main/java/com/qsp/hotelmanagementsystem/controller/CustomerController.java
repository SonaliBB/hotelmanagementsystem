package com.qsp.hotelmanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hotelmanagementsystem.dto.Customer;
import com.qsp.hotelmanagementsystem.service.CustomerService;
import com.qsp.hotelmanagementsystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	

@ApiOperation(value = "save customer",notes = "api is used to save customer ")
@ApiResponses(value = {@ApiResponse(code = 201,message = "customer saved successfully"),@ApiResponse(code = 404,message = "customer  does not saved, enter the valid details")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@Valid @RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	

@ApiOperation(value = "update customer",notes = "api is used to update customer ")
@ApiResponses(value = {@ApiResponse(code = 200,message = "customer saved successfully"),@ApiResponse(code = 404,message = "customer  does not updated, enter the valid details")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Customer>> updaCustomer(@Valid @RequestParam int cid,@RequestBody Customer customer) {
		return customerService.updaCustomer(cid, customer);
	}
	

@ApiOperation(value = "delete customer",notes = "api is used to delete customer ")
@ApiResponses(value = {@ApiResponse(code = 200,message = "customer saved successfully"),@ApiResponse(code = 404,message = "customer  does not deleted, enter the valid details")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Customer>> deleCustomer(@Valid @RequestParam int cid) {
		return customerService.deleteCustomer(cid);
		
	}

@ApiOperation(value = "get customer by id",notes = "api is used to get customer by id ")
@ApiResponses(value = {@ApiResponse(code =302,message = "customer data fetched successfully"),@ApiResponse(code = 404,message = "customer  not found, enter the valid details")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@Valid @RequestParam int cid) {
		return customerService.getCustomerById(cid);
	}

@ApiOperation(value = "get customer by Email",notes = "api is used to get customer by Email")
@ApiResponses(value = {@ApiResponse(code = 302,message = "customer data fetched successfully"),@ApiResponse(code = 404,message = "customer  not found, enter the valid details")})
	@GetMapping("/getcustomermyemail")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerByEmail(@Valid @RequestParam String c_email) {
		return customerService.getCustomerByEmail(c_email);
	}

@ApiOperation(value = "get all customer",notes = "api is used to get all customer  ")
@ApiResponses(value = {@ApiResponse(code = 302,message = " All customer data fetched successfully"),@ApiResponse(code = 404,message = "customer  not found, enter the valid details")})
	@GetMapping("/getallcustomers")
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers(){
		return customerService.getallCustomers();
	}

@ApiOperation(value = "Login Customer",notes = "api is used to login customer")
@ApiResponses(value = {@ApiResponse(code = 302,message = "customer login successfully"),@ApiResponse(code = 404,message = "customer  not found, enter the valid details")})	
	@GetMapping("/customerlogin")
	public ResponseEntity<ResponseStructure<Customer>> loginCustomer(@Valid @RequestParam String email,@RequestParam String password)
	{
		return customerService.loginCustomer(email, password);
	}
	
}

