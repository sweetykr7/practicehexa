package com.hexapractice.todo.application.service

import com.hexapractice.todo.application.domain.Todo
import com.hexapractice.todo.application.port.TodoCommandPort
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TodoCommandServiceTest {

    private val todoCommandPort: TodoCommandPort = mockk()
    private val todoCommandService = TodoCommandService(todoCommandPort)

    @Test
    fun `createTodo 메서드가 새로운 Todo를 생성하는지 테스트`() {
        // Given
        val todo = Todo.builder()
                .id(1L)
                .content("Test content")
                .build()
        every { todoCommandPort.createTodo(any()) } returns todo

        // When
        val result = todoCommandService.createTodo(todo)

        // Then
        assertEquals(todo.id, result.id)
        assertEquals(todo.content, result.content)
        assertEquals(todo.deletedAt, result.deletedAt)
    }

    @Test
    fun `updateTodo 메서드가 기존 Todo 객체를 수정하는지 테스트`() {
        // Given
        val existingTodo = Todo.builder()
                .id(1L)
                .content("Original Content")
                .build()

        every { todoCommandPort.updateTodo(existingTodo) } answers {
            existingTodo.content = "Updated Content"
            existingTodo // 기존 객체를 반환
        }

        // When
        val result = todoCommandService.updateTodo(existingTodo)

        // Then
        assertEquals("Updated Content", result.content)
        assertEquals(existingTodo.id, result.id)
        assertEquals(existingTodo, result) // 같은 객체인지 확인
    }

    @Test
    fun `deleteTodo 메서드가 Todo를 삭제하는지 테스트`() {
        // Given
        val todoId = 1L
        every { todoCommandPort.deleteTodo(todoId) } returns Unit

        // When
        todoCommandService.deleteTodo(todoId)

        // Then
        // 정상적으로 예외가 발생하지 않으면 성공
    }
}
