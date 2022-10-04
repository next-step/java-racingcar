package calculator;

import exception.ErrorCode;

public enum NumberException implements ErrorCode {
    NEGATIVE_NUMBER_BAD_REQUEST("음수는 입력할 수 없습니다.");

    private final String message;

    NumberException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
