package com.example.chatting.domain.chat.entity;

import com.example.chatting.global.common.BaseTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "room")
    private List<UserToRoom> userToRooms = new ArrayList<>();

    @OneToMany(mappedBy = "room")
    private List<Message> messages = new ArrayList<>();

    @Builder
    public Room(String name) {
        this.name = name;
    }
}