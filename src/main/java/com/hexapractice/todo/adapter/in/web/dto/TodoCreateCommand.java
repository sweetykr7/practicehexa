package com.hexapractice.todo.adapter.in.web.dto;

import jakarta.validation.constraints.NotNull;

public record TodoCreateCommand(
        @NotNull String content
) {
}
