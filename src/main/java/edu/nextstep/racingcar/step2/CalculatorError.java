package edu.nextstep.racingcar.step2;

import edu.nextstep.racingcar.common.BusinessError;

public enum CalculatorError implements BusinessError {
    INVALID_VALUE("잘못된 값입니다."),
    INVALID_CALCULATE_VALUE("잘못된 값입니다."),
    INVALID_CALCULATE_STRING("잘못된 연산 값입니다."),
    CAN_NOT_DIVIDE_BY_ZERO("0 으로 나눌 수 없습니다.");;

    private final String message;

    CalculatorError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
