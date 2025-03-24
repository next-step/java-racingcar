package com.nextstep.camp.racing.domain.exception;

public class UtilInstantiationException extends RuntimeException {

    private static final String MESSAGE = "유틸리티 클래스는 인스턴스화 할 수 없습니다.";

    public UtilInstantiationException() {
        super(MESSAGE);
    }
}
