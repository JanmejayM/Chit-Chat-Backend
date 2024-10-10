package com.chat.application.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.application.dto.ChatRoomDto;
import com.chat.application.model.ChatRoom;
import com.chat.application.repository.ChatRoomRepository;

@Service
public class ChatRoomServiceImpl implements ChatRoomService{
	
	@Autowired
	private ChatRoomRepository chatRoomRepository;

	@Override
	public void addUsersToChatRoom(long chatRoomId,Set<Long> userids) {
		// TODO Auto-generated method stub
		
		ChatRoom chatRoom=chatRoomRepository.getById(chatRoomId);
		
		Set <Long>userid=chatRoom.getUserid();
		userid.addAll(userids);
		
		chatRoom.setUserid(userid);
		
		chatRoomRepository.save(chatRoom);
		
		
		
	}

	@Override
	public void createChatRoom(long userid,String roomName) {
		// TODO Auto-generated method stub
		
		ChatRoom chatRoom=new ChatRoom();
		chatRoom.setRoomName(roomName);
		Set <Long>userids=chatRoom.getUserid();
		userids.add(userid);

		chatRoom.setUserid(userids);
		
		chatRoomRepository.save(chatRoom);
		
		
		
	}

	@Override
	public List<ChatRoom> getChatRoomsOfUser(long userId) {
		// TODO Auto-generated method stub
	return  chatRoomRepository.findAll().stream().filter(x->x.getUserid().contains(userId)).collect(Collectors.toList());
	}
	
	public List<ChatRoom> getAllChatRooms(){
		return chatRoomRepository.findAll();
	}

	@Override
	public ChatRoomDto getChatRoomDetails(long roomId) {
		// TODO Auto-generated method stub
		Optional<ChatRoom>chatRoom= chatRoomRepository.findById(roomId);
		ChatRoomDto chatRoomDto=new ChatRoomDto();
		if(chatRoom.isPresent()) {
			chatRoomDto.setChatRoomId(chatRoom.get().getId());
			chatRoomDto.setChatRoomName(chatRoom.get().getRoomName());
		}
		return chatRoomDto;
	}

}
