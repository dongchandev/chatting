package com.example.chatting.domain.chat.entity;

import com.example.chatting.domain.user.entity.User;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "camp_to_facility")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserToRoom {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;
}