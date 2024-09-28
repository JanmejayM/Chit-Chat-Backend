package com.user.application.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class UserInfo {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String emailId;
	private String password;
	private String role;

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserInfo(long id, String name, String emailId, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", emailId=" + emailId + ", password=" + password + ", role="
				+ role + "]";
	}
	
	
	
	
	
	

}
