package com.example.chatting;

import com.example.chatting.global.config.auth.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({JwtProperties.class})
@SpringBootApplication
public class ChattingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChattingApplication.class, args);
    }

}
