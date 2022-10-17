package racingcar.exception;

import exception.ErrorCode;

public enum RacingCarErrorCode implements ErrorCode {

    CARS_LENGTH_BAD_REQUEST("자동차를 입력해주세요."),
    MOVE_NUMBER_BAD_REQUEST("이동횟수는 정수만 입력가능합니다.");

    private final String message;

    RacingCarErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
