package com.chat.application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.chat.application.dto.ChatDto;
import com.chat.application.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;

@Entity
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userid;
	
	private String username;


	private String message;
	
	private LocalDateTime time;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "chatRoom_id")
	public ChatRoom chatRoom;

	public Long getId() {
		return id;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ChatRoom getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}

	@PrePersist
	protected void onCreate() {
		this.time = LocalDateTime.now();
	}

	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chat(ChatDto chatDto) {
		this.userid = chatDto.getUserid();
		this.message = chatDto.getMessage();
		this.username=chatDto.getUsername();

	}

	public Chat(Long id, Long userid, String message, LocalDateTime time, ChatRoom chatRoom) {
		super();
		this.id = id;
		this.userid = userid;
		this.message = message;
		this.time = time;
		this.chatRoom = chatRoom;
	}

}
