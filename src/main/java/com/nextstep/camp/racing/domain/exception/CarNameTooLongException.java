package com.nextstep.camp.racing.domain.exception;

public class CarNameTooLongException extends RuntimeException {
    private static final String MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";

    public CarNameTooLongException() {
        super(MESSAGE);
    }
}
