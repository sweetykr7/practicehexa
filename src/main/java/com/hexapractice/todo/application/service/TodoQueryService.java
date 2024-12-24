package com.hexapractice.todo.application.service;

import com.hexapractice.todo.application.domain.Todo;
import com.hexapractice.todo.application.port.TodoQueryPort;
import com.hexapractice.todo.application.usecase.TodoReadUseCase;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoQueryService implements TodoReadUseCase {
    private final TodoQueryPort todoQueryPort;

    @Override
    @Transactional(readOnly = true)
    public Page<Todo> getTodoList(Pageable pageable) {
        return todoQueryPort.findAllTodo(pageable);
    }
    @Override
    @Transactional(readOnly = true)
    public Todo getTodo(Long id){
        return todoQueryPort.findTodoById(id).orElseThrow(
                () -> new IllegalArgumentException("Todo not found")
        );
    }
}
