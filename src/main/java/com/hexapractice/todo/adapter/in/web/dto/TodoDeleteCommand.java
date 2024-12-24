package com.hexapractice.todo.adapter.in.web.dto;

import jakarta.validation.constraints.NotNull;

public record TodoDeleteCommand(
        @NotNull Long id
) {
}
