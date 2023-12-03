package com.qsp.hotelmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hotelmanagementsystem.dao.HotelDao;
import com.qsp.hotelmanagementsystem.dto.Hotel;
import com.qsp.hotelmanagementsystem.exception.IdNotFoundException;
import com.qsp.hotelmanagementsystem.util.ResponseStructure;

@Service
public class HotelService {
	@Autowired
	private HotelDao hoteldao;
	
	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(Hotel hotel) {
		ResponseStructure<Hotel> responseStructure=new  ResponseStructure<>();
		responseStructure.setMessage("saved succesfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(hoteldao.saveHotel(hotel));
		return   new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(int hid,Hotel hotel) {
		ResponseStructure<Hotel> responseStructure=new ResponseStructure<>();
		Hotel dbHotel=hoteldao.getHotelById(hid);
		if(dbHotel!=null) {
			hotel.setHotel_id(hid);
			responseStructure.setMessage("updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hoteldao.updateHotel(hotel));
			return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Hotel>> getHotelbyid(int hid) {
		ResponseStructure<Hotel> responseStructure=new ResponseStructure<>();
		Hotel hotel=hoteldao.getHotelById(hid);
		if(hotel!=null) {
			responseStructure.setMessage("found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hoteldao.getHotelById(hid));
			return new  ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Hotel>> deleteHotel(int hid) {
		ResponseStructure<Hotel> responseStructure=new ResponseStructure<>();
		Hotel hotel=hoteldao.getHotelById(hid);
		if (hotel!=null) {
			responseStructure.setMessage("data deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hoteldao.deleteHotel(hid));
			return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	
}
