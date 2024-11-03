package com.chat.application.response;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ApiResponse handleException(RuntimeException e) {
		
		ApiResponse apiResponse=new ApiResponse();
		String []response=e.getMessage().split(":");
		apiResponse.setMessage(response[0]);
		apiResponse.setStatuscode(Integer.valueOf(response[1]));
		
		return apiResponse;
		
	}

}
