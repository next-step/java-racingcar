package com.nextstep.camp.racing.domain.exception;

public class InvalidTypeException extends RuntimeException {
    private static final String MESSAGE = "Invalid type";

    public InvalidTypeException() {
        super(MESSAGE);
    }
}
