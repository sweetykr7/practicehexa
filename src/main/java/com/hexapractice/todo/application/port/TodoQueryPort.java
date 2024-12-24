package com.hexapractice.todo.application.port;

import com.hexapractice.todo.application.domain.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TodoQueryPort {
    Page<Todo> findAllTodo(Pageable pageable);
    Optional<Todo> findTodoById(Long id);
}