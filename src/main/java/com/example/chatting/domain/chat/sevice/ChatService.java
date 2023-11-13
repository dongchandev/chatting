package com.example.chatting.domain.chat.sevice;

import com.example.chatting.domain.chat.dto.MessageDto;
import com.example.chatting.domain.chat.dto.RoomCreateDto;
import com.example.chatting.domain.chat.entity.Message;
import com.example.chatting.domain.chat.entity.Room;
import com.example.chatting.domain.chat.repository.MessageRepository;
import com.example.chatting.domain.chat.repository.RoomRepository;
import com.example.chatting.global.exception.chat.ChatNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatService {

    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;

    @Transactional
    public RoomCreateDto createRoom(String name) {
        Room room = Room.builder().name(name).build();
        roomRepository.save(room);
        return new RoomCreateDto(room.getId().toString());
    }

    @Transactional
    public void sendMessage(MessageDto message) {
        Optional.of(roomRepository.findById(Long.parseLong(message.getRoomId()))).ifPresentOrElse(
                room -> messageRepository.save(Message.builder()
                        .room(room.get())
                        .text(message.getMessage()).build()), () -> {throw ChatNotFoundException.EXCEPTION;});
    }
}