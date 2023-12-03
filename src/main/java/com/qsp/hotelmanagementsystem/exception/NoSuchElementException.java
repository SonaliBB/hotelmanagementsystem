package com.qsp.hotelmanagementsystem.exception;

public class NoSuchElementException extends RuntimeException {

	private String message="no such element present";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
	public NoSuchElementException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementException() {
		super();
		
	}
	
	
}
