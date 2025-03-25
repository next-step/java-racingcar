package com.nextstep.camp.racing.domain.exception;

public class CarNameCannotBeBlankException extends RuntimeException {
    private static final String MESSAGE = "자동차 이름은 비어있을 수 없습니다.";

    public CarNameCannotBeBlankException() {
        super(MESSAGE);
    }
}
