package racingcar;

import exception.ErrorCode;

public enum RacingCarErrorCode implements ErrorCode {

    CAR_NUMBER_BAD_REQUEST("자동차 수는 정수만 입력가능합니다."),
    MOVE_NUMBER_BAD_REQUEST("이동횟수는 정수만 입력가능합니다.");

    private final String message;

    RacingCarErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
