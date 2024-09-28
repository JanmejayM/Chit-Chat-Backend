package com.user.application.payload;

import com.user.application.entity.UserInfo;

public class UserDto {
	
	private long id;
	
	private String name;
	
	private String email;
	

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(UserInfo userInfo) {
		name=userInfo.getName();
		email=userInfo.getEmailId();
		id=userInfo.getId();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	
	
	
	
	
	

}
