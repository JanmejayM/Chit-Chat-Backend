package com.chat.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat.application.model.Chat;
import com.chat.application.model.ChatRoom;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>{

	List<Chat> findAllByChatRoomId(long chatRoomId,Pageable pageable);

	
	

}
