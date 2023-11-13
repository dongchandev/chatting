package com.example.chatting.domain.user.entity;

import com.example.chatting.global.common.BaseTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTime {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(strategy = "uuid2", name="uuid2")
    @Column(name = "user_id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID userId;
    private String loginId;
    private String password;
    private String nickname;
    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;
}
