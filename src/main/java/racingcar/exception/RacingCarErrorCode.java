package racingcar.exception;

import exception.ErrorCode;

public enum RacingCarErrorCode implements ErrorCode {

    MOVE_NUMBER_BAD_REQUEST("이동횟수는 정수만 입력가능합니다.");

    private final String message;

    RacingCarErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
