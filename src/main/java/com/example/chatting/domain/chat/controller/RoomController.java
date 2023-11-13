package com.example.chatting.domain.chat.controller;

import com.example.chatting.domain.chat.dto.RoomCreateDto;
import com.example.chatting.domain.chat.sevice.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    private final ChatService chatService;

    @PostMapping("/{roomName}")
    public RoomCreateDto createRoom(@PathVariable("roomName") String name) {
        return chatService.createRoom(name);
    }
}