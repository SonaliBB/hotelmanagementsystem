package com.qsp.hotelmanagementsystem.exception;

public class IdNotFoundException extends RuntimeException {

	private String message="id is present";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundException() {
		super();
		
	}
	
	
}
