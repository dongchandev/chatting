package com.example.chatting.domain.chat.repository;

import com.example.chatting.domain.chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}