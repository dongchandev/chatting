package com.example.chatting.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusEnum {

    //chat
    CHAT_NOT_FOUND(404,"Chat Not Found"),

    // login
    EXPIRED_TOKEN(401 , "Expired token"),
    INVALID_TOKEN(401, "Invalid token"),
    OAUTH_FAIL(401, "OAuth failed"),
    REFRESH_TOKEN_NOT_FOUND(403,"RefreshToken not found"),

    // general
    OK(200,"OK"),
    CREATED(201,"Created"),
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error"),

    //user
    USER_EXISTS(403, "User exists"),
    USER_NOT_FOUND(404, "User not found"),
    NOT_AUTHENTICATED(401, "NotAuthenticated"),

    //file
    FILE_NOT_FOUND(404,"File not found"),
    FILE_EXISTS(403,"File exists"),

    //post
    POST_NOT_FOUND(404,"Post not found"),
    NOT_CORRECT_DATE(400,"Not correct param"),
    TODAY_MAX_DIARY(400,"오늘 이미 2개의 일기를 작성하셨습니다.");

    private final int statusCode;
    private final String message;
}