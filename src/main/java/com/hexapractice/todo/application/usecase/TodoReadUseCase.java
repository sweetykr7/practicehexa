package com.hexapractice.todo.application.usecase;

import com.hexapractice.todo.application.domain.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoReadUseCase {
    Page<Todo> getTodoList(Pageable pageable);

    Todo getTodo(Long id);
}

