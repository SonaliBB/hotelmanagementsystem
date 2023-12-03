package com.qsp.hotelmanagementsystem.controller;

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

import com.qsp.hotelmanagementsystem.dto.Hotel;
import com.qsp.hotelmanagementsystem.service.HotelService;
import com.qsp.hotelmanagementsystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@ApiOperation(value = "save hotel",notes="api is used to save hotel")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "hotel created successfully"),@ApiResponse(code = 404,message = "hotel not saved give proper input")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(@Valid @RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);

	}

	
	@ApiOperation(value = "update hotel",notes="api is used to update hotel")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "hotel successfully updated"),@ApiResponse(code = 404,message = "hotel not updated give proper input")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(@Valid @RequestParam int hid, @RequestBody Hotel hotel) {
		return hotelService.updateHotel(hid, hotel);
	}

	@ApiOperation(value = "delete hotel" ,notes="api is used to delete hotel")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "hotel deleted successfully"),@ApiResponse(code = 404,message = "hote not deleted please give correct inputs")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Hotel>> deleteHotel(@Valid @RequestParam int hid) {
		return hotelService.deleteHotel(hid);

	}

	@ApiOperation(value = "get hote by id", notes="api is used to get hotel by id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "given hotel details found"),@ApiResponse(code = 404,message = "hotel id not found")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Hotel>> gethotelbyid(@Valid @RequestParam int hid) {
		return hotelService.getHotelbyid(hid);

	}
	
}
