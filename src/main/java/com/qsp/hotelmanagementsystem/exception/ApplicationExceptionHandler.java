package com.qsp.hotelmanagementsystem.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.hotelmanagementsystem.util.ResponseStructure;

import net.bytebuddy.asm.Advice.Return;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
ResponseStructure<String> responseStructure=new ResponseStructure<>();

@ExceptionHandler(MaxNumberOfPeopleException.class)
public ResponseEntity<ResponseStructure<String>> maxNumberOfPeopleException(MaxNumberOfPeopleException ex)
{
	responseStructure.setMessage("max limit for people for particular room ");
	responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
	responseStructure.setData(ex.getMessage());
	return  new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(IdNotFoundException.class)
public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFoundException ex){
	responseStructure.setMessage("id not found");
	responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
	responseStructure.setData(ex.getMessage());
	return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
}

@ExceptionHandler(EmailNotFoundException.class)
public ResponseEntity<ResponseStructure<String>> emailNotFoundException(EmailNotFoundException ex){
	responseStructure.setMessage("please enter the valid email id");
	responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
	responseStructure.setData(ex.getMessage());
	return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
}

@ExceptionHandler(RoomAvailabilityException.class)
public ResponseEntity<ResponseStructure<String>> roomAvailabilityException(RoomAvailabilityException ex){
	responseStructure.setMessage("please enter valid availability value");
	responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
	responseStructure.setData(ex.getMessage());
	return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
}

@ExceptionHandler(RoomTypeException.class)
public ResponseEntity<ResponseStructure<String>> roomTypeException(RoomTypeException ex){
	responseStructure.setMessage("please enter the valid Room type");
	responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
	responseStructure.setData(ex.getMessage());
	return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
}

@ExceptionHandler(RoomNoNotPresentException.class)
public ResponseEntity<ResponseStructure<String>> roomNoNotPresentException(RoomNoNotPresentException ex){
	responseStructure.setMessage("please enter the valid room number");
	responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
	responseStructure.setData(ex.getMessage());
	return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
}
@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<ResponseStructure<String>> noSuchElementException(NoSuchElementException ex){
	responseStructure.setMessage("no such element found");
	responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
	responseStructure.setData(ex.getMessage());
	return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
}

@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> lis=ex.getAllErrors();
		Map<String, String> map=new LinkedHashMap<>();
		for (ObjectError objectError : lis) {
			String fieldname=((FieldError)objectError).getField();
			String message=((FieldError)objectError).getDefaultMessage();
			map.put(fieldname, message);

	}
return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}

@ExceptionHandler(ConstraintViolationException.class)
public ResponseEntity<ResponseStructure<String>> constraintVoilationException(ConstraintViolationException ex){
	responseStructure.setData(ex.getMessage());
	responseStructure.setMessage("this Field cannot be null or blank");
	responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
	return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
}
}
