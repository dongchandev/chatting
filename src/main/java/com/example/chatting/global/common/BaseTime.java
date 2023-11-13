package com.example.chatting.global.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
@Table(name="base_time")
public abstract class BaseTime {
    @CreatedDate
    @Column(name = "created_time",nullable = false, updatable = false)
    protected LocalDate createdDate;

    @LastModifiedDate
    @Column(name="modified_time",nullable = false, updatable = false)
    protected LocalDate modifiedDate;
}