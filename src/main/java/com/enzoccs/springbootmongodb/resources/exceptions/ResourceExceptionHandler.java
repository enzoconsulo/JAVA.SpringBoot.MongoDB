package com.enzoccs.springbootmongodb.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.enzoccs.springbootmongodb.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(exception = ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus statusError = HttpStatus.NOT_FOUND;
		StandartError error = new StandartError(System.currentTimeMillis(), statusError.value(), "Invalid id", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(statusError).body(error);
	}
	
}
