package com.user.application.exception;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.application.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=UserAlreadyExistsException.class)
	public ResponseEntity<ApiResponse> UserAlreadyExistsException(UserAlreadyExistsException ex)
	{
		String message=ex.getMessage();
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		LocalDate localDate = zonedDateTime.toLocalDate();

		ApiResponse apiResponse=new ApiResponse(message,localDate,HttpStatus.FORBIDDEN);
	     return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.FORBIDDEN);
	}

	
	@ExceptionHandler(value=UserNotExistException.class)
	public ResponseEntity<ApiResponse> UserNotExistException(UserNotExistException ex)
	{
		String message=ex.getMessage();
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		LocalDate localDate = zonedDateTime.toLocalDate();

		ApiResponse apiResponse=new ApiResponse(message,localDate,HttpStatus.FORBIDDEN);
	     return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value=org.springframework.web.client.HttpClientErrorException.Forbidden.class)
	public ResponseEntity<ApiResponse> forbidden(org.springframework.web.client.HttpClientErrorException.Forbidden ex)
	{
		String message=ex.getMessage();
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		LocalDate localDate = zonedDateTime.toLocalDate();

		ApiResponse apiResponse=new ApiResponse(message,localDate,HttpStatus.FORBIDDEN);
	     return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.FORBIDDEN);
	}


}
