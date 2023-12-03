package com.qsp.hotelmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hotelmanagementsystem.dto.Hotel;
import com.qsp.hotelmanagementsystem.repository.HotelRepo;
@Repository
public class HotelDao {
 
	@Autowired
	private HotelRepo hotelrepo;
	
	public Hotel saveHotel(Hotel hotel) {
		return hotelrepo.save(hotel);
	}
	
	public Hotel  updateHotel(Hotel hotel) {
		return hotelrepo.save(hotel);
	}
	
	public Hotel deleteHotel(int hid) {
		if(hotelrepo.findById(hid).isPresent()) {
			Hotel hotel=hotelrepo.findById(hid).get();
			hotelrepo.delete(hotel);
			return hotel;
		}
		return null;
	}
	
	public Hotel getHotelById(int hid) {
		if(hotelrepo.findById(hid).isPresent()) {
			return hotelrepo.findById(hid).get();
		}
		return null;
	}
}
