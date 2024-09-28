package com.chat.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat.application.model.ChatRoom;


@Repository
public interface ChatRoomRepository  extends JpaRepository<ChatRoom, Long>{

}
