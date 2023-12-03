package com.qsp.hotelmanagementsystem.exception;

public class ConstraintViolationException extends RuntimeException {

	private String message="This field can't be null";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	public ConstraintViolationException(String message) {
		super();
		this.message = message;
	}

	public ConstraintViolationException() {
		super();
		
	}
	
	
}
