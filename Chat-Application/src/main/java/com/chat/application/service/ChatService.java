package com.chat.application.service;

import java.util.List;

import com.chat.application.dto.ChatDto;
import com.chat.application.model.Chat;

public interface ChatService {
	
	public Chat addChat(ChatDto chatDto);
	public List<Chat>getChat(int pageSize,int pageNo,long chatRoomId);
	public List<Chat>getRecentChat(long chatRoomId);
	public Integer getMaxPage(long chatRoomId);



}
