package com.nextstep.camp.racing.domain.exception;

public class ViewDataNotFoundException extends RuntimeException {
    private static final String MESSAGE = "ViewData가 없습니다.";

    public ViewDataNotFoundException() {
        super(MESSAGE);
    }
}
