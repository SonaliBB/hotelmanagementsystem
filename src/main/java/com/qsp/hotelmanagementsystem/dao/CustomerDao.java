package com.qsp.hotelmanagementsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hotelmanagementsystem.dto.Customer;
import com.qsp.hotelmanagementsystem.repository.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired 
	private CustomerRepo customerRepo;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
		
	}
	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
		
	}
	public Customer deleteCustomer(Customer customer) {
		customerRepo.delete(customer);
		return customer;
		
	}
	public Customer getCustomerById(int cid) {
		if(customerRepo.findById(cid).isPresent()) {
			return customerRepo.findById(cid).get();
		}
		return  null;
	}
	
	public Customer getCustomerByEmail(String c_email) {
		if(customerRepo.getCustomerByEmail(c_email)!=null) {
			return customerRepo.getCustomerByEmail(c_email);
		}
		return null;
	}
	
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
	
}
