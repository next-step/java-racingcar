package racingcar.exception;

import exception.ErrorCode;
import racingcar.Car;

public enum CarErrorCode implements ErrorCode {

    CAR_NAME_LENGTH_BAD_REQUEST("자동차 이름은 "+ Car.NAME_MAXIMUM_VALUE +"자를 초과할 수 없습니다.");

    private final String message;

    CarErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
