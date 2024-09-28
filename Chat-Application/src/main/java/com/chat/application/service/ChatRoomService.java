package com.chat.application.service;

import java.util.List;
import java.util.Set;

import com.chat.application.model.ChatRoom;

public interface ChatRoomService {
	public void createChatRoom(long userid, String roomName);

	public void addUsersToChatRoom(long chatRoomId, Set<Long> userids);

	public List<ChatRoom> getChatRoomsOfUser(long userId);

	public List<ChatRoom> getAllChatRooms();
}
