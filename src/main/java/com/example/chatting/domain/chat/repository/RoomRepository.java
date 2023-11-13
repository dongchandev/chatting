package com.example.chatting.domain.chat.repository;

import com.example.chatting.domain.chat.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}