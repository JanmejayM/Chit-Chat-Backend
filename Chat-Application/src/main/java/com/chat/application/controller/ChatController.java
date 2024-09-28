package com.chat.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.application.dto.ChatDto;
import com.chat.application.model.Chat;
import com.chat.application.service.ChatService;

@RestController
public class ChatController {

	@Autowired
	private ChatService chatService;

	@MessageMapping("/send-message/{chatRoomId}")
	@SendTo("/topic/messages/{chatRoomId}")
	public Chat sendMessage(@RequestBody ChatDto chatDto, @DestinationVariable long chatRoomId) {

		System.out.println(chatRoomId);
		Chat saved = chatService.addChat(chatDto);
		return saved;
	}

}
