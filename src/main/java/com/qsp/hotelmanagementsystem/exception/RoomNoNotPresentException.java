package com.qsp.hotelmanagementsystem.exception;

public class RoomNoNotPresentException extends RuntimeException {
 
	private String message="given room no is not found";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	public RoomNoNotPresentException(String message) {
		super();
		this.message = message;
	}

	public RoomNoNotPresentException() {
		super();
	}
	
	
}
