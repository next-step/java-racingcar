package edu.nextstep.racingcar.step3;

public enum CarError {
    INVALID_VALUE("잘못된 값입니다.");

    private final String message;

    CarError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
