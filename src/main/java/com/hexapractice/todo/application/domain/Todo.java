package com.hexapractice.todo.application.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Todo {

    private Long id;
    private String content;
    private LocalDateTime deletedAt;

    @Builder
    public Todo (Long id, String content){
        this.id = id;
        this.content = content;
        this.deletedAt = null;
    }
}
