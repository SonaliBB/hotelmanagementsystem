package com.qsp.hotelmanagementsystem.controller;

import java.util.List;

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

import com.qsp.hotelmanagementsystem.dto.Room;
import com.qsp.hotelmanagementsystem.service.RoomService;
import com.qsp.hotelmanagementsystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/room")
class RoomController {
@Autowired
private RoomService roomService;

@ApiOperation(value = "save room",notes = "api is used to save room")
@ApiResponses(value = {@ApiResponse(code = 201,message = "room details saved successfully"),@ApiResponse(code = 404,message = "room isn't saved please enter the valid details")})
@PostMapping
public  ResponseEntity<ResponseStructure<Room>> saveRoom(@Valid @RequestBody Room room,@RequestParam int hid) {
	return roomService.saveRoom(room, hid);
	
}

@ApiOperation(value = "update room" ,notes = "api is used to update room")
@ApiResponses(value = {@ApiResponse(code = 200,message = "room details updated successfully"),@ApiResponse(code = 404,message = "room isn't updated, please enter the valid details")})
@PutMapping
public ResponseEntity<ResponseStructure<Room>> updateRoom(@Valid @RequestParam int rid,@RequestBody Room room) {
	return roomService.updateRoom(rid, room);
}
@ApiOperation(value = "delete room", notes = "api is used to delete room")
@ApiResponses(value = {@ApiResponse(code = 200,message = "room details deleted successfully"),@ApiResponse(code = 404,message = "room isn't deleted please enter the valid details")})
@DeleteMapping
public ResponseEntity<ResponseStructure<Room>> deleteRoom(@Valid @RequestParam int rid) {
	return roomService.deleteRoom(rid);
	
}
@ApiOperation(value = "get  room by id",notes = "api is used to get room by id")
@ApiResponses(value = {@ApiResponse(code = 200,message = "room details fetched successfully"),@ApiResponse(code = 404,message = "room not found please enter the valid details")})
@GetMapping
public ResponseEntity<ResponseStructure<Room>> getRoomById(@Valid @RequestParam int id) {
	return roomService.getRoomById(id);
}

@ApiOperation(value = "get  room by no",notes = "api is used to get room by no")
@ApiResponses(value = {@ApiResponse(code = 200,message = "room details fetched successfully"),@ApiResponse(code = 404,message = "room not found please enter the valid details")})@GetMapping("/roombyno")
public ResponseEntity<ResponseStructure<Room>> getRoomByNo(@Valid @RequestParam int room_no) {
	return roomService.getRoomByNo(room_no);
}


@ApiOperation(value = "get  room by type",notes = "api is used to get room by type")
@ApiResponses(value = {@ApiResponse(code = 200,message = "room details fetched successfully"),@ApiResponse(code = 404,message = "room not found please enter the valid details")})
@GetMapping("/roombytype")
public ResponseEntity<ResponseStructure<List<Room>>> getRoomByType(@Valid @RequestParam String room_type) {
	return roomService.getRoomByType(room_type);
}


@ApiOperation(value = "get  room by availability",notes = "api is used to get room by avilability")
@ApiResponses(value = {@ApiResponse(code = 200,message = "room details fetched successfully"),@ApiResponse(code = 404,message = "room not found please enter the valid details")})
@GetMapping("/roombyavailability")
public ResponseEntity<ResponseStructure<List<Room>>> getRoomByAvailability(@Valid @RequestParam String availability) {
	return roomService.getRoomByAvailability(availability);
}


@ApiOperation(value = "get  all rooms",notes = "api is used to get all rooms")
@ApiResponses(value = {@ApiResponse(code = 200,message = "All room details fetched successfully"),@ApiResponse(code = 404,message = "room not found please enter the valid details")})
@GetMapping("/getallrooms")
public ResponseEntity<ResponseStructure<List<Room>>> getAllRooms() {
	return roomService.getAllRooms();
}







}
