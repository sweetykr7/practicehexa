package com.hexapractice.todo.adapter.out.mapper;

import com.hexapractice.todo.adapter.out.persistence.entity.TodoEntity;
import com.hexapractice.todo.application.domain.Todo;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TodoEntityMapper {
    Todo toDomain(TodoEntity todoEntity);

    TodoEntity toEntity(Todo todo);

    default Optional<Todo> toOptionalDomain(TodoEntity todoEntity){
        return Optional.ofNullable(toDomain(todoEntity));
    }
}
