package com.kkambi.racing.domain;

public enum Error {

    INVALID_ARGUMENT("올바르지 않은 초기값입니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
