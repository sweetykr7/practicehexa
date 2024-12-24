package com.hexapractice.todo.adapter.out.persistence;

import com.hexapractice.todo.adapter.out.mapper.TodoEntityMapper;
import com.hexapractice.todo.adapter.out.persistence.entity.TodoEntity;
import com.hexapractice.todo.application.domain.Todo;
import com.hexapractice.todo.application.port.TodoQueryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.hexapractice.todo.adapter.out.persistence.entity.QTodoEntity.todoEntity;

@Repository
public class TodoQueryAdapter extends QuerydslRepositorySupport implements TodoQueryPort {

    private final TodoEntityMapper todoEntityMapper;

    public TodoQueryAdapter(TodoEntityMapper todoEntityMapper) {
        super(TodoEntity.class);
        this.todoEntityMapper = todoEntityMapper;
    }

    @Override
    public Page<Todo> findAllTodo(Pageable pageable) {
        // 삭제되지 않은 투두 조회
        var result = getQuerydsl().createQuery()
                .select(todoEntity)
                .from(todoEntity)
                .where(
                        todoEntity.deletedAt.isNull()
                ).fetch();

        var totalCount = getQuerydsl().createQuery()
                .select(todoEntity.count())
                .from(todoEntity)
                .where(
                        todoEntity.deletedAt.isNull()
                );

        return PageableExecutionUtils.getPage(
                result.stream().map(todoEntityMapper::toDomain).toList(),
                pageable,
                totalCount::fetchOne);
    }

    @Override
    public Optional<Todo> findTodoById(Long id) {
        return todoEntityMapper.toOptionalDomain(
                getQuerydsl().createQuery()
                        .select(todoEntity)
                        .from(todoEntity)
                        .where(
                                todoEntity.id.eq(id),
                                todoEntity.deletedAt.isNull()
                        ).fetchOne()
        );
    }
}

