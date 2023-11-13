package com.example.chatting.global.config.auth;


import com.example.chatting.domain.user.Repository.UserRepository;
import com.example.chatting.domain.user.entity.User;
import com.example.chatting.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) {

        User user = userRepository.findByNickname(name)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        return new CustomUserDetails(user);
    }
}
