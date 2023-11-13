package com.example.chatting.global.exception.token;


import com.example.chatting.global.error.exception.BusinessException;
import com.example.chatting.global.error.exception.StatusEnum;

public class ExpiredTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException(){
        super(StatusEnum.EXPIRED_TOKEN);
    }

}
