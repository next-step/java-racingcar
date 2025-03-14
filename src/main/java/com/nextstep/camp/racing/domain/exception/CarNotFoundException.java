package com.nextstep.camp.racing.domain.exception;

public class CarNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Car가 없습니다.";

    public CarNotFoundException() {
        super(MESSAGE);
    }
}
