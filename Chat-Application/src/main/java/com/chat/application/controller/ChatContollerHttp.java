package com.chat.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.application.model.Chat;
import com.chat.application.service.ChatService;

@CrossOrigin("*")
@RestController 
@RequestMapping("chat")
public class ChatContollerHttp {
	
	@Autowired
	private ChatService chatService;
	
	
	@GetMapping("/getMaxPage")
	public Integer getMaxPage(@RequestParam(defaultValue = "1") long chatRoomId)
	{
		return chatService.getMaxPage(chatRoomId);
	}
	
	@GetMapping("/allMessage")
	public List<Chat> getAllMessage(@RequestParam(defaultValue = "1") long chatRoomId)
	{
		return chatService.getRecentChat(chatRoomId);
	}
	
	@GetMapping("/loadMessage")
	public List<Chat> getAllMessagePage(@RequestParam int pageSize,@RequestParam int pageNo,@RequestParam(defaultValue = "1") long chatRoomId,@RequestParam int maxPage)
	{
		//int maxPage=chatService.getMaxPage(chatRoomId);
		return chatService.getChat(pageSize,maxPage-pageNo,chatRoomId);
	}

}
