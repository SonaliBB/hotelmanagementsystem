package com.qsp.hotelmanagementsystem.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int room_id;
	@NotNull(message = "room no cannot be null")
	@NotBlank(message = "room no cannot be blank")
private int room_no;
	@NotNull(message = "room type cannot be null")
	@NotBlank(message = "room type cannot be blank")
private String room_type;
	@NotNull(message = "room price cannot be null")
	@NotBlank(message = "room price cannot be blank")
private int room_price;
@Min(value = 1)
@Max(value = 10)
private int no_beds;
@Min(value = 1)
@Max(value = 10)
private int max_people;
@NotNull(message = "availability cannot be null")
@NotBlank(message = "availability cannot be blank")
@Pattern(regexp ="[Y,N]")
private String availability;
@Enumerated(EnumType.STRING)
private Floor floor;
@ManyToOne
private Hotel hotel;

public int getRoom_id() {
	return room_id;
}

public void setRoom_id(int room_id) {
	this.room_id = room_id;
}

public int getRoom_no() {
	return room_no;
}

public void setRoom_no(int room_no) {
	this.room_no = room_no;
}

public String getRoom_type() {
	return room_type;
}

public void setRoom_type(String room_type) {
	this.room_type = room_type;
}

public int getRoom_price() {
	return room_price;
}

public void setRoom_price(int room_price) {
	this.room_price = room_price;
}

public int getNo_beds() {
	return no_beds;
}

public void setNo_beds(int no_beds) {
	this.no_beds = no_beds;
}

public int getMax_people() {
	return max_people;
}

public void setMax_people(int max_people) {
	this.max_people = max_people;
}

public String getAvailability() {
	return availability;
}

public void setAvailability(String availability) {
	this.availability = availability;
}

public Floor getFloor() {
	return floor;
}

public void setFloor(Floor floor) {
	this.floor = floor;
}

public Hotel getHotel() {
	return hotel;
}

public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}



}
