package com.cognizant.LearnTodayRESTAPI.dao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.cognizant.LearnTodayRESTAPI.dao.exception.InvalidEnrollmentIdException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(InvalidEnrollmentIdException.class)
	public ResponseEntity<Object> invalidEnrollmentException(InvalidEnrollmentIdException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);}
	@ExceptionHandler(InvalidTrainerIdException.class)
	public ResponseEntity<Object> invalidTrainerIdException(InvalidTrainerIdException e){
		return new ResponseEntity<>( e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}