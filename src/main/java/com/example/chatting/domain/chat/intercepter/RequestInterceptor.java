package com.example.chatting.domain.chat.intercepter;

import com.example.chatting.domain.user.entity.User;
import com.example.chatting.domain.user.service.GetCurrentUser;
import com.example.chatting.global.config.auth.jwt.JwtUtil;
import com.example.chatting.global.exception.token.InvalidTokenException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


import java.util.Enumeration;

@Component
@RequiredArgsConstructor
public class RequestInterceptor implements HandlerInterceptor {
    private final GetCurrentUser getCurrentUser;
    private final JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }

//        if (!(handlerMethod.getMethod().isAnnotationPresent(CheckToken.class))) {
//            return true;
//        }

        String token = extract(request);

        if(token.isEmpty()) {
            throw InvalidTokenException.EXCEPTION;
        }

        User user = getCurrentUser.getUser();
        request.setAttribute("user", user);

        return true;
    }

    private String extract(HttpServletRequest request) {

        Enumeration<String> headers = request.getHeaders("Authorization");

        while (headers.hasMoreElements()) {

            String value = headers.nextElement();
            if (value != null) {
                return value;
            }
        }
        
        return Strings.EMPTY;
    }
}