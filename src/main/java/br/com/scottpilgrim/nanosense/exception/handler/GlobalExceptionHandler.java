package br.com.scottpilgrim.nanosense.exception.handler;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.scottpilgrim.nanosense.exception.BadRequestException;
import br.com.scottpilgrim.nanosense.exception.ExceptionResponse;
import br.com.scottpilgrim.nanosense.exception.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), 
																	ex.getMessage(), 
																	request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(RuntimeException ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), 
																	ex.getMessage(), 
																	request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestException(RuntimeException ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), 
																	ex.getMessage(), 
																	request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}