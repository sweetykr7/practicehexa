package com.hexapractice.todo.application.service;

import com.hexapractice.todo.application.domain.Todo;
import com.hexapractice.todo.application.port.TodoCommandPort;
import com.hexapractice.todo.application.usecase.TodoCreateUseCase;
import com.hexapractice.todo.application.usecase.TodoDeleteUseCase;
import com.hexapractice.todo.application.usecase.TodoUpdateUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoCommandService implements TodoCreateUseCase, TodoUpdateUseCase, TodoDeleteUseCase {
    private final TodoCommandPort todoCommandPort;

    @Transactional
    @Override
    public Todo createTodo(Todo todo){
        return todoCommandPort.createTodo(todo);
    }

    @Transactional
    @Override
    public Todo updateTodo(Todo todo){
        return todoCommandPort.updateTodo(todo);
    }

    @Transactional
    @Override
    public void deleteTodo(Long todoId){
        todoCommandPort.deleteTodo(todoId);
    }
}
