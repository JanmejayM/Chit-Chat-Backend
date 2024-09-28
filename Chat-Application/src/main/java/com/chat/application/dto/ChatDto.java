package com.chat.application.dto;

public class ChatDto {
	
    private Long userid;
	
	
	private String message;
	
	public Long chatRoomId;

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

	public long getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(Long chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	public ChatDto(Long userid, String message, Long chatRoomId) {
		super();
		this.userid = userid;
		this.message = message;
		this.chatRoomId = chatRoomId;
	}

	public ChatDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ChatDto [userid=" + userid + ", message=" + message + ", chatRoomId=" + chatRoomId + "]";
	}
	
	
	
	
	

}
