package com.qsp.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hotelmanagementsystem.dao.HotelDao;
import com.qsp.hotelmanagementsystem.dao.RoomDao;
import com.qsp.hotelmanagementsystem.dto.Hotel;
import com.qsp.hotelmanagementsystem.dto.Room;
import com.qsp.hotelmanagementsystem.exception.IdNotFoundException;
import com.qsp.hotelmanagementsystem.exception.RoomAvailabilityException;
import com.qsp.hotelmanagementsystem.exception.RoomNoNotPresentException;
import com.qsp.hotelmanagementsystem.exception.RoomTypeException;
import com.qsp.hotelmanagementsystem.util.ResponseStructure;

@Service
public class RoomService {

	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private HotelDao hotelDao;
	ResponseStructure<Room> responseStructure=new ResponseStructure<>();
	public ResponseEntity<ResponseStructure<Room>> saveRoom(Room room,int hid) {
		Hotel hotel=hotelDao.getHotelById(hid);
		room.setHotel(hotel);
		Room room2=roomDao.saveRoom(room);
		
		if (room2!=null) {
			responseStructure.setMessage("data saved successfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(room2);
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.CREATED);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Room>>	updateRoom(int rid,Room room) {
	Room dbRoom=roomDao.getRoomById(rid);
	if (dbRoom!=null) {
		room.setRoom_id(rid);
		room.setHotel(dbRoom.getHotel());
		responseStructure.setMessage("data updated successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(room);
		return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);
	}
	else {
		throw new IdNotFoundException();
	}
	}
	
	public ResponseEntity<ResponseStructure<Room>> deleteRoom(int rid) {
		Room room=roomDao.getRoomById(rid);
		if (room!=null) {
			responseStructure.setMessage("data deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(room);
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);	
		}
		else {
			throw new IdNotFoundException();
		 }
	}
	
	
	public ResponseEntity<ResponseStructure<Room>> getRoomById(int rid) {
		Room room=roomDao.getRoomById(rid);
		if (room!=null) {
			responseStructure.setMessage("data fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(roomDao.getRoomById(rid));
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomByType(String room_type) {
		ResponseStructure<List<Room>> responseStructure=new ResponseStructure<>();
		List<Room> rooms=roomDao.getRoomByType(room_type);
		if (rooms!=null) {
			responseStructure.setMessage("data fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(roomDao.getRoomByType(room_type));
			return new ResponseEntity<ResponseStructure<List<Room>>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new RoomTypeException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Room>> getRoomByNo(int room_no) {
		Room room=roomDao.getRoomByNo(room_no);
		if (room!=null) {
			responseStructure.setMessage("data fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(roomDao.getRoomByNo(room_no));
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new RoomNoNotPresentException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomByAvailability(String availability) {
		ResponseStructure<List<Room>> responseStructure=new ResponseStructure<>();
		List<Room> rooms=roomDao.getRoomByAvailability(availability);
		if (rooms!=null) {
			responseStructure.setMessage("data fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(roomDao.getRoomByAvailability(availability));
			return new ResponseEntity<ResponseStructure<List<Room>>>(responseStructure,HttpStatus.FOUND);
		}
		else {
		  throw new RoomAvailabilityException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Room>>> getAllRooms() {
		ResponseStructure<List<Room>> responseStructure=new ResponseStructure<>();
		if (roomDao.getAllRooms()!=null) {
			responseStructure.setMessage("data fetched successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(roomDao.getAllRooms());
			return new ResponseEntity<ResponseStructure<List<Room>>>(responseStructure,HttpStatus.FOUND);
		}
           throw new IdNotFoundException();
	}
}
