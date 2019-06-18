package com.jaeyeonling.exception;

public class NotCompleteException extends IllegalStateException {

    private static final String ERROR_MESSAGE = "결과가 나오지 않은 게임입니다.";

    public NotCompleteException() {
        super(ERROR_MESSAGE);
    }
}
