package edu.nextstep.racingcar.step3.error;

import edu.nextstep.racingcar.common.BusinessError;

public enum CarError implements BusinessError {
    INVALID_VALUE("잘못된 값입니다."),
    INVALID_VALUE_GREAT_THAN_THRESHOLD("랜덤 최대 값은 입계 값보다 커야 합니다.");

    private final String message;

    CarError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
