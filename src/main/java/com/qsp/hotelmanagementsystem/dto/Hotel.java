package com.qsp.hotelmanagementsystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int hotel_id;
	@NotNull(message = "hotel name cannot be null")
	@NotBlank(message = "hotel name cannot be blank")
private String hotel_name;
	
	@NotNull(message = "hotel gst cannot be null")
	@NotBlank(message = "hotel gst cannot be blank")
private String hotel_gst;
	
	@NotNull(message = "hotel address cannot be null")
	@NotBlank(message = "hotel address cannot be blank")
private String hotel_address;
	@NotNull(message = "hotel manager cannot be null")
	@NotBlank(message = "hotel manager cannot be blank")
private String hotel_manager;
	@NotNull(message = "hotel owner cannot be null")
	@NotBlank(message = "hotel owner cannot be blank")
private String hotel_owner;
private int hotel_rating;
public int getHotel_id() {
	return hotel_id;
}
public void setHotel_id(int hotel_id) {
	this.hotel_id = hotel_id;
}
public String getHotel_name() {
	return hotel_name;
}
public void setHotel_name(String hotel_name) {
	this.hotel_name = hotel_name;
}
public String getHotel_gst() {
	return hotel_gst;
}
public void setHotel_gst(String hotel_gst) {
	this.hotel_gst = hotel_gst;
}
public String getHotel_address() {
	return hotel_address;
}
public void setHotel_address(String hotel_address) {
	this.hotel_address = hotel_address;
}
public String getHotel_manager() {
	return hotel_manager;
}
public void setHotel_manager(String hotel_manager) {
	this.hotel_manager = hotel_manager;
}
public String getHotel_owner() {
	return hotel_owner;
}
public void setHotel_owner(String hotel_owner) {
	this.hotel_owner = hotel_owner;
}
public int getHotel_rating() {
	return hotel_rating;
}
public void setHotel_rating(int hotel_rating) {
	this.hotel_rating = hotel_rating;
}


}
