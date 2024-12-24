package com.hexapractice.todo.adapter.in.web;

import com.hexapractice.todo.adapter.in.mapper.TodoDtoMapper;
import com.hexapractice.todo.adapter.in.web.dto.TodoCreateCommand;
import com.hexapractice.todo.adapter.in.web.dto.TodoDeleteCommand;
import com.hexapractice.todo.adapter.in.web.dto.TodoDto;
import com.hexapractice.todo.adapter.in.web.dto.TodoUpdateCommand;
import com.hexapractice.todo.application.usecase.TodoCreateUseCase;
import com.hexapractice.todo.application.usecase.TodoDeleteUseCase;
import com.hexapractice.todo.application.usecase.TodoUpdateUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "todo-command-controller")
@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class TodoCommandController {

    private final TodoCreateUseCase todoCreateUseCase;
    private final TodoUpdateUseCase todoUpdateUseCase;
    private final TodoDeleteUseCase todoDeleteUseCase;
    private final TodoDtoMapper todoDtoMapper;

    @Operation(
            summary = "할 일 등록 API",
            description = "등록할 할 일 데이터를 전달받아 새로운 할 일을 등록합니다."
    )
    @PostMapping
    public ResponseEntity<TodoDto> create(@RequestBody @Valid TodoCreateCommand command) {

        var todo = todoCreateUseCase.createTodo(todoDtoMapper.toDomain(command));

        return ResponseEntity.ok(todoDtoMapper.toDto(todo));
    }

    @Operation(
            summary = "할 일 수정 API",
            description = "수정할 항목(들)을 전달받아 할 일을 수정합니다."
    )
    @PatchMapping("/{todoId}")
    public ResponseEntity<TodoDto> update(@RequestBody TodoUpdateCommand command) {

        var todo = todoUpdateUseCase.updateTodo(todoDtoMapper.toDomain(command));

        return ResponseEntity.ok(todoDtoMapper.toDto(todo));
    }

    @Operation(
            summary = "할 일 삭제 API",
            description = "삭제할 할 일의 PK 값을 전달받아 할 일을 삭제합니다."
    )
    @DeleteMapping("/{todoId}")
    public void delete(@RequestBody TodoDeleteCommand command) {

        todoDeleteUseCase.deleteTodo(command.id());
    }
}

