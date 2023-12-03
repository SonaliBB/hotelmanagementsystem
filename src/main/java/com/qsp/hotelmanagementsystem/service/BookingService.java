package com.qsp.hotelmanagementsystem.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hotelmanagementsystem.dao.BookingDao;
import com.qsp.hotelmanagementsystem.dao.CustomerDao;
import com.qsp.hotelmanagementsystem.dao.RoomDao;
import com.qsp.hotelmanagementsystem.dto.Booking;
import com.qsp.hotelmanagementsystem.dto.Customer;
import com.qsp.hotelmanagementsystem.dto.Room;
import com.qsp.hotelmanagementsystem.exception.IdNotFoundException;
import com.qsp.hotelmanagementsystem.exception.MaxNumberOfPeopleException;
import com.qsp.hotelmanagementsystem.util.ResponseStructure;

@Service
public class BookingService {

	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private RoomDao roomDao;
	ResponseStructure<Booking> responseStructure=new ResponseStructure<>();
	
	public  ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking,int cid,int rid) {
	 
		Room room=roomDao.getRoomById(rid);
		room.setAvailability("N");
		if (booking.getNo_people()<=room.getMax_people()) {
			Room room2=roomDao.updateRoom(room);
			Customer customer=customerDao.getCustomerById(cid);
			booking.setCustomer(customer);
			booking.setRoom(room2);
			LocalDateTime check_in_date=LocalDateTime.now();
			booking.setCheck_in_date(check_in_date);
			responseStructure.setMessage("data saved successfully");
			responseStructure.setData(bookingDao.saveBooking(booking));
			responseStructure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.CREATED);	
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(Booking booking,int bid) {
		Booking dbbooking=bookingDao.getBookingById(bid);
		if (dbbooking!=null) {
			if (booking.getNo_people()<=dbbooking.getRoom().getMax_people()) {
				booking.setId(bid);
				booking.setCustomer(dbbooking.getCustomer());
				booking.setRoom(dbbooking.getRoom());
				booking.setCheck_in_date(dbbooking.getCheck_in_date());
				booking.setCheck_out_date(dbbooking.getCheck_out_date());
				responseStructure.setMessage("data deleted successfully ");
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(bookingDao.updateBooking(booking));
				return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.OK);
			}
			throw new  MaxNumberOfPeopleException();
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(int bid) {
		Booking booking=bookingDao.getBookingById(bid);
		if (booking!=null) {
			responseStructure.setMessage("deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(bookingDao.deleteBooking(booking));
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		 }
	}
	
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(int bid) {
		Booking booking=bookingDao.getBookingById(bid);
		if (booking!=null) {
			responseStructure.setMessage("fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(bookingDao.getBookingById(bid));
			return  new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBookings() {
	ResponseStructure<List<Booking>> responseStructure=new  ResponseStructure<>();
		if (bookingDao.getAllBookings()!=null) {
			responseStructure.setMessage("fetched all Bookings");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(bookingDao.getAllBookings());
			return new ResponseEntity<ResponseStructure<List<Booking>>>(responseStructure,HttpStatus.FOUND);
		} else {
      throw new IdNotFoundException() ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Booking>> closeBooking(int bid) {
		Booking booking=bookingDao.getBookingById(bid);
		if (booking!=null) {
			LocalDateTime check_out_date=LocalDateTime.now();
			booking.setCheck_out_date(check_out_date);
			Room room=booking.getRoom();
			room.setAvailability("Y");
			booking.setRoom(room);
			responseStructure.setMessage("fetched booking by id");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(bookingDao.updateBooking(booking));
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	
}
