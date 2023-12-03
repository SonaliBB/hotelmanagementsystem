package com.qsp.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hotelmanagementsystem.dao.CustomerDao;
import com.qsp.hotelmanagementsystem.dto.Admin;
import com.qsp.hotelmanagementsystem.dto.Customer;
import com.qsp.hotelmanagementsystem.exception.EmailNotFoundException;
import com.qsp.hotelmanagementsystem.exception.IdNotFoundException;
import com.qsp.hotelmanagementsystem.exception.NoSuchElementException;
import com.qsp.hotelmanagementsystem.util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
	public ResponseEntity<ResponseStructure<Customer>>	saveCustomer(Customer customer) {
		Customer dbCustomer=customerDao.saveCustomer(customer);
		if (dbCustomer!=null) {
			responseStructure.setMessage("saved successfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dbCustomer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.CREATED);
		}
		else {
			throw new NoSuchElementException();
		}
	}
	
	
	public ResponseEntity<ResponseStructure<Customer>> updaCustomer(int cid,Customer customer) {
		Customer dbCustomer=customerDao.getCustomerById(cid);
		if (dbCustomer!=null) {
			customer.setC_id(cid);
			responseStructure.setMessage("updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(customerDao.updateCustomer(customer));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int cid) {
		Customer customer=customerDao.getCustomerById(cid);
		if (customer!=null) {
			responseStructure.setMessage("deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(customerDao.deleteCustomer(customer));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);
			
		}
		else {
			throw new IdNotFoundException();
			
		}
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int cid) {
		Customer customer=customerDao.getCustomerById(cid);
		if (customer!=null) {
			responseStructure.setMessage("fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(customerDao.getCustomerById(cid));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerByEmail(String c_email) {
		Customer customer=customerDao.getCustomerByEmail(c_email);
		if (customer!=null) {
			responseStructure.setMessage("fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(customerDao.getCustomerByEmail(c_email));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new EmailNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Customer>>> getallCustomers() {
		ResponseStructure<List<Customer>>  responseStructure=new  ResponseStructure<>();
		if (customerDao.getAllCustomers()!=null) {
			responseStructure.setMessage("fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(customerDao.getAllCustomers());
			return new ResponseEntity<ResponseStructure<List<Customer>>>(responseStructure,HttpStatus.FOUND);
		
		}
		throw new NoSuchElementException();
	}
	
	public ResponseEntity<ResponseStructure<Customer>> loginCustomer(String email,String password) {
		Customer customer=customerDao.getCustomerByEmail(email);
		if (customer.getC_password().equals(password)) {
			responseStructure.setMessage("login successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);
		
		}
		else {
			responseStructure.setMessage("Please enter the valid username and password");
			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.BAD_REQUEST);
		
		 }
	}
	
}
