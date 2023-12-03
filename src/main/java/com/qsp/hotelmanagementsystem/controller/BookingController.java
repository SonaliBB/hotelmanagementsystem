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

import com.qsp.hotelmanagementsystem.dto.Booking;
import com.qsp.hotelmanagementsystem.service.BookingService;
import com.qsp.hotelmanagementsystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired 
	private BookingService bookingService;

@ApiOperation(value = "Save Booking",notes = "api is used to save booking")
@ApiResponses(value = {@ApiResponse(code = 201,message = " Booking details saved successfully"),@ApiResponse(code = 404,message = "Booking not saved, enter the valid details")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@Valid @RequestBody Booking booking,@RequestParam int cid,@RequestParam int rid) {
		return bookingService.saveBooking(booking, cid, rid);
		
	}

@ApiOperation(value = "update Booking",notes = "api is used to update booking")
@ApiResponses(value = {@ApiResponse(code = 200,message = " Booking details updated successfully"),@ApiResponse(code = 404,message = "Booking not updated, enter the valid details")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@Valid @RequestBody Booking booking,@RequestParam int bid) {
	return bookingService.updateBooking(booking, bid);
	
	}

@ApiOperation(value = "delete Booking",notes = "api is used to delete booking")
@ApiResponses(value = {@ApiResponse(code = 200,message = " Booking details deleted successfully"),@ApiResponse(code = 404,message = "Booking not deleted, enter the valid details")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Booking>> deleBooking(@Valid @RequestParam int id) {
		return bookingService.deleteBooking(id);
	}

@ApiOperation(value = "get Booking by id",notes = "api is used to get booking by id")
@ApiResponses(value = {@ApiResponse(code = 302,message = " Booking details fetched successfully"),@ApiResponse(code = 404,message = "Booking not found, enter the valid details")})
	@GetMapping("/bookingbyid")
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(@Valid @RequestParam int bid) {
		return bookingService.getBookingById(bid);
	}

@ApiOperation(value = "get all Booking",notes = "api is used to get all booking")
@ApiResponses(value = {@ApiResponse(code =302,message = "All Booking details fetched successfully"),@ApiResponse(code = 404,message = "Booking not found, enter the valid details")})
	@GetMapping("/getallbooking")
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBookings(){
		return bookingService.getAllBookings();
	}

@ApiOperation(value = "close Booking",notes = "api is used to close booking ")
@ApiResponses(value = {@ApiResponse(code = 200,message = " Booking closed successfully"),@ApiResponse(code = 404,message = "Booking not found, enter the valid details")})
	@PutMapping("/closebooking")
	public ResponseEntity<ResponseStructure<Booking>> closeBooking(@Valid @RequestParam int bid) {
		return bookingService.closeBooking(bid);
	}
	
}
