package com.example.chatting.global.exception.chat;

import com.example.chatting.global.error.exception.BusinessException;
import com.example.chatting.global.error.exception.StatusEnum;

public class ChatNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new ChatNotFoundException();

    public ChatNotFoundException(){
        super(StatusEnum.CHAT_NOT_FOUND);
    }

}
