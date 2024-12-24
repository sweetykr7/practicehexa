package com.hexapractice.todo.application.usecase;

import com.hexapractice.todo.application.domain.Todo;

public interface TodoCreateUseCase {
    Todo createTodo(Todo todo);
}
