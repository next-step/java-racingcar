package com.nextstep.camp.racing.domain.exception;

public class NegativeNumberException extends RuntimeException {

    private static final String MESSAGE = "음수는 할당할 수 없습니다.";

    public NegativeNumberException() {
        super(MESSAGE);
    }
}
