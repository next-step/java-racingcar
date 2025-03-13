package com.nextstep.camp.racing.domain.exception;

public class NotNumberException extends RuntimeException {

    private static final String MESSAGE = "숫자가 아닌 값은 할당할 수 없습니다.";

    public NotNumberException() {
        super(MESSAGE);
    }
}
