package com.hexapractice.todo.adapter.in.mapper;

import com.hexapractice.todo.adapter.in.web.dto.TodoCreateCommand;
import com.hexapractice.todo.adapter.in.web.dto.TodoDto;
import com.hexapractice.todo.adapter.in.web.dto.TodoUpdateCommand;
import com.hexapractice.todo.application.domain.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoDtoMapper {

    TodoDto toDto(Todo todo);

    Todo toDomain(TodoCreateCommand command);
    Todo toDomain(TodoUpdateCommand command);
}