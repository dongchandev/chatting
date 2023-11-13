package com.example.chatting.domain.user.Repository;

import com.example.chatting.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUserId(UUID userId);
    Optional<User> findByNickname(String nickName);

}
