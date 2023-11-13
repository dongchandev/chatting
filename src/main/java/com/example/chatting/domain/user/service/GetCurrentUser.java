package com.example.chatting.domain.user.service;

import com.example.chatting.domain.user.entity.User;
import com.example.chatting.global.config.auth.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetCurrentUser {
    public User getUser() {
        return getUserDetails().user();
    }

    public UUID getUserId(){
        return this.getUser().getUserId();
    }

    private CustomUserDetails getUserDetails() {
        return ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
