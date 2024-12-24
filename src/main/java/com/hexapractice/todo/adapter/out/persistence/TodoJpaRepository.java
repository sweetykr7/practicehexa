package com.hexapractice.todo.adapter.out.persistence;


import com.hexapractice.todo.adapter.out.persistence.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoJpaRepository extends JpaRepository<TodoEntity, Long> {
}
