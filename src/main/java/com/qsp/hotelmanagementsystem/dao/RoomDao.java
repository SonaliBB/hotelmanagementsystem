package com.qsp.hotelmanagementsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hotelmanagementsystem.dto.Room;
import com.qsp.hotelmanagementsystem.repository.RoomRepo;

@Repository
public class RoomDao {
  @Autowired
	private RoomRepo roomRepo;
  
  public Room saveRoom(Room room) {
	return roomRepo.save(room);
}
  
  public Room  updateRoom(Room room) {
	return roomRepo.save(room);
}
  public Room  deleteRoom(Room room) {
	roomRepo.delete(room);
	return room;
}
  
  public Room  getRoomById(int rid) {
	if(roomRepo.getRoomById(rid)!=null) {
		return roomRepo.getRoomById(rid);
	}
	return null;
}
  
  public List<Room> getAllRooms() {
	  return roomRepo.findAll();
	  
}
  public Room  getRoomByNo(int room_no) {
if(roomRepo.getRoomByNo(room_no)!=null) {
	return roomRepo.getRoomByNo(room_no);
}
return null;
}
  public List<Room>  getRoomByType(String room_type) {
	  if(roomRepo.getRoomByType(room_type)!=null) {
	  	return roomRepo.getRoomByType(room_type);
	  }
	  return null;
	  }
  
  public List<Room> getRoomByAvailability(String availability) {
	if(roomRepo.getRoomByAvailability(availability)!=null) {
		return roomRepo.getRoomByAvailability(availability);
	}
	return null;
}
}
