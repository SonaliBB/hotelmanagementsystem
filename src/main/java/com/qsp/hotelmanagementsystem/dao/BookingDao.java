package com.qsp.hotelmanagementsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hotelmanagementsystem.dto.Booking;
import com.qsp.hotelmanagementsystem.repository.BookingRepo;

@Repository
public class BookingDao {

	@Autowired
	private BookingRepo bookingRepo;
	
	public Booking  saveBooking(Booking booking	) {
		return bookingRepo.save(booking);
	}
	
	
	public Booking updateBooking(Booking booking) {
		return bookingRepo.save(booking);
	}
	
	public Booking deleteBooking(Booking booking) {
		bookingRepo.delete(booking);
		
		return booking;
	}
	
	public Booking getBookingById(int bid) {
		if (bookingRepo.findById(bid).isPresent()) {
			return bookingRepo.findById(bid).get();
		}
		return null;
	}
	
	public List<Booking> getAllBookings() {
		return bookingRepo.findAll();
	}
	
	public Booking getBookingByCheckIn(String check_in_date) {
		if (bookingRepo.getBookingByCheckIn(check_in_date)!=null) {
			 return bookingRepo.getBookingByCheckIn(check_in_date);
		}
		return null;
	}
	
	public Booking getBookingByCheckOut(String check_out_date) {
		if (bookingRepo.getBookingByCheckOut(check_out_date)!=null) {
			return bookingRepo.getBookingByCheckOut(check_out_date);
			
		}
		return null;
	}
	
}
