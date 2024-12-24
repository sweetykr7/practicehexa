package com.hexapractice.todo.adapter.in.web.dto;

import jakarta.validation.constraints.NotNull;

public record TodoUpdateCommand(
        @NotNull Long id,
        @NotNull String content
) {
}
