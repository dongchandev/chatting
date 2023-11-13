package com.example.chatting.global.exception.token;

import com.example.chatting.global.error.exception.BusinessException;
import com.example.chatting.global.error.exception.StatusEnum;

public class InvalidTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException(){
        super(StatusEnum.INVALID_TOKEN);
    }

}