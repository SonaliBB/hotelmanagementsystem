package com.qsp.hotelmanagementsystem.exception;

public class RoomTypeException extends RuntimeException {

	
	private String message="Room type is not valid";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	public RoomTypeException(String message) {
		super();
		this.message = message;
	}

	public RoomTypeException() {
		super();
	}
	
	
}
