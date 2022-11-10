package com.masai.exceptions;

import java.time.LocalDateTime;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	ResponseEntity<MyErrorDetails> noHandlerException(NoHandlerFoundException nfe, WebRequest req) {

		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(nfe.getMessage());
		errorDetails.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(PackageException.class)
	ResponseEntity<MyErrorDetails> packageExceptionHandler(PackageException pe, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(pe.getMessage());
		errorDetails.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserException.class)
	ResponseEntity<MyErrorDetails> userExceptionHandler(UserException ue, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ue.getMessage());
		errorDetails.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.OK);
	}

}