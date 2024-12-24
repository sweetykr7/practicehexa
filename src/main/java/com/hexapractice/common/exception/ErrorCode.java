package com.hexapractice.common.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String name();
    String defaultMessage();
    HttpStatus defaultHttpStatus();
    RuntimeException defaultException();
    RuntimeException defaultException(Throwable cause);
}