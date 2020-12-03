package com.nextstep.calculator.domain.exceptions;

public class InvalidNumberException extends RuntimeException {
    public InvalidNumberException(String message) {
        super(message);
    }
}
