package com.esh;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = Exception.class) // club two exception by value = Exception.class, UserServiceException.class
	public ResponseEntity<ErrorMessage> handleAnyException(Exception ex, WebRequest webrequest) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(new Date(), ex.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<ErrorMessage> handleNullPOinterExceptions(NullPointerException ex, WebRequest webrequest) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(new Date(), "Null point exception handling"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = UserServiceException.class)
	public ResponseEntity<ErrorMessage> handleUserServiceException(UserServiceException ex, WebRequest webrequest) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(new Date(), ex.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

class ErrorMessage {
	private Date date;
	private String message;

	ErrorMessage(Date date, String message) {
		this.date = date;
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
