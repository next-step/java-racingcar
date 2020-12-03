package com.nextstep.calculator.domain.exceptions;

public class InvalidOperatorException extends RuntimeException {
    public InvalidOperatorException(String message) {
        super(message);
    }
}
