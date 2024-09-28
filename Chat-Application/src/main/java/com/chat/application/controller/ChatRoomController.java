package com.chat.application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.application.dto.ChatRoomDto;
import com.chat.application.model.ChatRoom;
import com.chat.application.service.ChatRoomService;

@RestController
@RequestMapping("chatRoom")
@CrossOrigin("*")
public class ChatRoomController {
	
	
	@Autowired
	private ChatRoomService chatRoomService;
	
	@PostMapping("/")
	public void createChatRoom(@RequestParam long userId,@RequestParam String roomName)
	{
		chatRoomService.createChatRoom(userId, roomName);
	}
	@PostMapping("/addUser")
	public void addUsersToChatRoom(@RequestParam long chatRoomId,@RequestParam Set<Long> userids)
	{
		chatRoomService.addUsersToChatRoom(chatRoomId, userids);
	}
	
	@GetMapping("/userChatRooms/{userId}")
	public List<ChatRoomDto> getChatRoom(@PathVariable long userId )
	{
		List<ChatRoom> chatRoom= chatRoomService.getChatRoomsOfUser(userId);
		List<ChatRoomDto>chatRoomDtos=new ArrayList<ChatRoomDto>();
	   chatRoom.stream().forEach((x)->{
		   chatRoomDtos.add(new ChatRoomDto(x.getId(), x.getRoomName()));
	   });
	   
	   return chatRoomDtos;
	}
	
	@GetMapping("/fetchAllChatRooms")
	public List<ChatRoom> getAllChatRoom()
	{
		
	   return chatRoomService.getAllChatRooms();
	}


}
