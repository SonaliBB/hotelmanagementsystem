package com.qsp.hotelmanagementsystem.exception;

public class EmailNotFoundException extends RuntimeException {

	private String message="given email id not found";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	

	public EmailNotFoundException(String message) {
		super();
		this.message = message;
	}

	public EmailNotFoundException() {
		super();
		
	}
	
	
	
}
