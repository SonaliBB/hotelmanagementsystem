package com.qsp.hotelmanagementsystem.exception;

public class MaxNumberOfPeopleException extends RuntimeException{
	
	private String message="we can't have these many number of people in the selected room ";
@Override
public String getMessage() {
	// TODO Auto-generated method stub
	return super.getMessage();
	
}
public MaxNumberOfPeopleException(String message) {
	super();
	this.message = message;
}
public MaxNumberOfPeopleException() {
	super();
	
}





}
