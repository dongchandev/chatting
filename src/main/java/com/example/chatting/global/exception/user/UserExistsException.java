package com.example.chatting.global.exception.user;

import com.example.chatting.global.error.exception.BusinessException;
import com.example.chatting.global.error.exception.StatusEnum;

public class UserExistsException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserExistsException();

    public UserExistsException() {
        super(StatusEnum.USER_EXISTS);
    }
}
