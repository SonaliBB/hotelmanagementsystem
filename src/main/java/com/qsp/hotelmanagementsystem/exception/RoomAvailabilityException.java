package com.qsp.hotelmanagementsystem.exception;

public class RoomAvailabilityException extends RuntimeException {

	private String message="Room is not available";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	public RoomAvailabilityException(String message) {
		super();
		this.message = message;
	}

	public RoomAvailabilityException() {
		super();
	}
	
	
	
}
