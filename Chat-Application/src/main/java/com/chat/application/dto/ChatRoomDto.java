package com.chat.application.dto;

public class ChatRoomDto {
	
	
	private long chatRoomId;
	
	private String chatRoomName;

	public long getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(long chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	public String getChatRoomName() {
		return chatRoomName;
	}

	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}

	public ChatRoomDto(long chatRoomId, String chatRoomName) {
		super();
		this.chatRoomId = chatRoomId;
		this.chatRoomName = chatRoomName;
	}

	public ChatRoomDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
