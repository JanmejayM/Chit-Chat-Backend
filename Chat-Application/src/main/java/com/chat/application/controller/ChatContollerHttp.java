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
	public Integer getMaxPage(@RequestParam long chatRoomId)
	{
		return chatService.getMaxPage(chatRoomId);
	}
	
	@GetMapping("/allMessage")
	public List<Chat> getAllMessage(@RequestParam long chatRoomId)
	{
		return chatService.getRecentChat(chatRoomId);
	}
	
	@GetMapping("/loadMessage")
	public List<Chat> getAllMessagePage(@RequestParam int pageSize,@RequestParam int pageNo,@RequestParam long chatRoomId,@RequestParam int maxPage)
	{
		//int maxPage=chatService.getMaxPage(chatRoomId);
		List<Chat>res= chatService.getChat(pageSize,maxPage-pageNo,chatRoomId);
		//System.out.println(res);
		return res;
	}

}
