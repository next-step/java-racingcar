package com.jaeyeonling.racingcar.exception;

public class CompleteException extends IllegalStateException {

    private static final String ERROR_MESSAGE = "이미 결과가 나온 게임입니다.";

    public CompleteException() {
        super(ERROR_MESSAGE);
    }
}
