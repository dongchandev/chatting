package com.example.chatting.global.exception.user;

import com.example.chatting.global.error.exception.BusinessException;
import com.example.chatting.global.error.exception.StatusEnum;

public class NotAuthenticatedException extends BusinessException {
    public static final BusinessException EXCEPTION = new NotAuthenticatedException();

    public NotAuthenticatedException() {
        super(StatusEnum.NOT_AUTHENTICATED);
    }
}
