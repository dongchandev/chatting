package com.example.chatting.global.exception.user;

import com.example.chatting.global.error.exception.BusinessException;
import com.example.chatting.global.error.exception.StatusEnum;

public class UserNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(StatusEnum.USER_NOT_FOUND);
    }
}
