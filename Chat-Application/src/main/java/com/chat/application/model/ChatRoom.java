package com.chat.application.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class ChatRoom {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String roomName;
	
	@OneToMany(mappedBy = "chatRoom",cascade = CascadeType.ALL)
	private List<Chat> chat=new ArrayList<Chat>();
	
	@ElementCollection(fetch = FetchType.LAZY)
	private Set<Long>userid=new HashSet<>();

	public ChatRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatRoom(Long id, String roomName, List<Chat> chat) {
		super();
		this.id = id;
		this.roomName = roomName;
		this.chat = chat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public List<Chat> getChat() {
		return chat;
	}

	public void setChat(List<Chat> chat) {
		this.chat = chat;
	}

	public Set<Long> getUserid() {
		return userid;
	}

	public void setUserid(Set<Long> userid) {
		this.userid = userid;
	}
	
	
	
	
	
	
	
	
	
	

}
