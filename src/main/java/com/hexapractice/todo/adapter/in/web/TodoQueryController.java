package com.hexapractice.todo.adapter.in.web;

import com.hexapractice.todo.adapter.in.mapper.TodoDtoMapper;
import com.hexapractice.todo.adapter.in.web.dto.TodoDto;
import com.hexapractice.todo.application.usecase.TodoReadUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "todo-query-controller")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoQueryController {

    private final TodoReadUseCase todoReadUseCase;
    private final TodoDtoMapper todoDtoMapper;

    @Operation(
            summary = "할 일 목록 조회 API",
            description = """
                    <p>
                        삭제되지 않은 할 일 목록 조회 
                    </p>
                    """
    )
    @GetMapping
    public ResponseEntity<Page<TodoDto>> getTodoList(Pageable pageable) {

        var todoList = todoReadUseCase.getTodoList(pageable).stream()
                .map(todoDtoMapper::toDto)
                .toList();

        return ResponseEntity.ok(new PageImpl<>(todoList, pageable, todoList.size()));
    }

    @Operation(
            summary = "할 일 상세 조회 API",
            description = """
                    <p>
                        id로 할 일 상세 조회
                   </p>
                    """
    )
    @GetMapping("/{todoId}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long todoId){
        var todo = todoReadUseCase.getTodo(todoId);

        return ResponseEntity.ok(todoDtoMapper.toDto(todo));
    }
}
