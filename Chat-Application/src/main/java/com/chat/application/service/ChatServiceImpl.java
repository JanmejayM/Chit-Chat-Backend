package com.chat.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.chat.application.dto.ChatDto;
import com.chat.application.model.Chat;
import com.chat.application.model.ChatRoom;
import com.chat.application.repository.ChatRepository;
import com.chat.application.repository.ChatRoomRepository;

@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatRepository chatRepository;
	
	@Autowired
	private ChatRoomRepository chatRoomRepository;
	
	public Chat addChat(ChatDto chatDto) {
		
		System.out.println(chatDto);
		Chat chat=new Chat(chatDto);
		
		ChatRoom chatRoom=chatRoomRepository.findById(chatDto.getChatRoomId()).get();
		chat.setChatRoom(chatRoom);
		
		return chatRepository.save(chat);
	}
	
	public List<Chat>getChat(int pageSize,int pageNo,long chatRoomId)
	{
		
		return chatRepository.findAllByChatRoomId(chatRoomId,PageRequest.of(pageNo,pageSize));
	}
	
	public List<Chat>getRecentChat(long chatRoomId)
	{
		
		List<Chat>ls=chatRepository.findAll().stream().filter(x->x.getChatRoom().getId()==chatRoomId).collect(Collectors.toList());
		return ls;
	}
	
	public Integer getMaxPage(long chatRoomId) {
		double totalRecord=chatRepository.findAll().stream().filter(x->x.getChatRoom().getId()==chatRoomId).count();
		int pageSize=10;
		
		System.out.println(totalRecord);
		double maxPageNumber=Math.ceil(totalRecord/(double)pageSize);
		
		if(totalRecord%pageSize==0|| totalRecord%pageSize==pageSize-1) {
			maxPageNumber++;
		}
		System.out.println(maxPageNumber);
		
		return (int)maxPageNumber;
	}
}
