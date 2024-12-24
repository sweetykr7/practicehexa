package com.hexapractice.todo.application.port;

import com.hexapractice.todo.application.domain.Todo;

public interface TodoCommandPort {
    Todo createTodo(Todo todo);
    Todo updateTodo(Todo todo);
    void deleteTodo(Long id);
}
