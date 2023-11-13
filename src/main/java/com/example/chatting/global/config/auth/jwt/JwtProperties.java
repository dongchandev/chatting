package com.example.chatting.global.config.auth.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Builder
@AllArgsConstructor
@Getter
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private final String secret;
    private final Long accessExpire;
    private final Long refreshExpire;
}
