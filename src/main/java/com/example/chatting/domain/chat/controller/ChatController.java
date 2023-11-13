package com.example.chatting.domain.chat.controller;

import com.example.chatting.domain.chat.dto.MessageDto;
import com.example.chatting.domain.chat.sevice.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatService chatService;

    @MessageMapping("/send")
    public void publish(MessageDto message) {
        System.out.println(message.getRoomId());
        System.out.println(message.getMessage());
        simpMessagingTemplate.convertAndSend("/sub/room/" + message.getRoomId(), message);
        chatService.sendMessage(message);
    }
}