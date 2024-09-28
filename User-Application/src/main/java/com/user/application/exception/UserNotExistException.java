package com.user.application.exception;

public class UserNotExistException extends RuntimeException{
	
	private String message;

	public UserNotExistException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	

}
