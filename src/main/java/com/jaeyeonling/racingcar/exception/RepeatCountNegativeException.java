package com.jaeyeonling.racingcar.exception;

public class RepeatCountNegativeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "반복 횟수는 양수만 가능합니다. (입력 값: %d)";

    public static final int MINIMUM_REPEAT_COUNT = 1;

    public RepeatCountNegativeException(final int input) {
        super(String.format(ERROR_MESSAGE, input));
    }
}
