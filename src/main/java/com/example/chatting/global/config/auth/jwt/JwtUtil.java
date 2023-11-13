package com.example.chatting.global.config.auth.jwt;


import com.example.chatting.domain.user.Repository.UserRepository;
import com.example.chatting.domain.user.entity.Role;
import com.example.chatting.domain.user.entity.User;
import com.example.chatting.global.config.auth.CustomUserDetails;
import com.example.chatting.global.exception.token.ExpiredTokenException;
import com.example.chatting.global.exception.token.InvalidTokenException;
import com.example.chatting.global.exception.user.UserNotFoundException;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {
    private final JwtProperties jwtProperties;
    private final UserRepository userRepository;

    public String generateAccessToken(final UUID id, final Role role) {
        Date date=new Date();
        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, "ACCESS")
                .setSubject(id.toString())
                .claim("Authorization", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getAccessExpire()))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
                .compact();
    }

    public String generateRefreshToken(final UUID id, final Role role) {
        Date date=new Date();
        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, "REFRESH")
                .setSubject(id.toString())
                .claim("Authorization", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getRefreshExpire()))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
                .compact();
    }

    public Authentication getAuthentication(String accessToken) {
        // 토큰 복호화
        Claims claims = getClaims(accessToken);
//        Jws<Claims> claims = getClaims(accessToken);

        User user = userRepository.findByUserId(UUID.fromString(claims.getSubject()))
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        log.info(user.getNickname());

        CustomUserDetails details = new CustomUserDetails(user);

        return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
    }

    public Claims getClaims(String token) {
//    public Jws<Claims> getClaims(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(jwtProperties.getSecret()).build().parseClaimsJws(token).getBody();
//            return Jwts.parserBuilder().setSigningKey(jwtProperties.getSecret()).build().parseClaimsJws(extractToken(token));

        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e){
            throw InvalidTokenException.EXCEPTION;
        }
    }

    public String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }

//    private String extractToken(final String token) {
//        if (StringUtils.hasText(token) && token.startsWith("Bearer")) {
//            return token.substring(7);
//        }
//
//        return token;
//    }
}