package com.qsp.hotelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.hotelmanagementsystem.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.c_email=?1")
	public Customer getCustomerByEmail(String c_email) ;
	
}
