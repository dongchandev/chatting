package com.example.chatting.domain.chat.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessageDto {

    private String sender;
    private String roomId;
    private String message;
}