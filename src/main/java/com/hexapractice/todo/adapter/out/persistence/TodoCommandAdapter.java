package com.hexapractice.todo.adapter.out.persistence;

import com.hexapractice.todo.adapter.out.mapper.TodoEntityMapper;
import com.hexapractice.todo.application.domain.Todo;
import com.hexapractice.todo.application.port.TodoCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TodoCommandAdapter implements TodoCommandPort {

    private final TodoJpaRepository todoJpaRepository;
    private final TodoEntityMapper todoEntityMapper;

    public Todo createTodo(Todo todo){
        var todoEntity = todoEntityMapper.toEntity(todo);
        return todoEntityMapper.toDomain(todoJpaRepository.save(todoEntity));
    }

    @Override
    public Todo updateTodo(Todo todo){
        var existTodo = todoJpaRepository.findById(todo.getId()).orElseThrow(
                () -> new IllegalArgumentException("todo not found")
        );
        existTodo.prepareUpdate()
                .content(todo.getContent())
                .update();
        return todoEntityMapper.toDomain(
                todoJpaRepository.save(existTodo));
    }

    @Override
    public void deleteTodo(Long id){
        var existTodo = todoJpaRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Todo not found")
        );
        existTodo.softDelete();
    }
}