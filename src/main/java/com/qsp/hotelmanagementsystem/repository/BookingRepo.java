package com.qsp.hotelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.hotelmanagementsystem.dto.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>{

	
	
	@Query("select b from Booking b where b.check_in_date=?1")
	public Booking getBookingByCheckIn(String check_in_date);
	
	@Query("select b from Booking b where b.check_out_date=?1")
	public Booking getBookingByCheckOut(String check_out_date);
	
}
