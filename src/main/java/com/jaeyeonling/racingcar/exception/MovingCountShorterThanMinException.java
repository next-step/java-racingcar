package com.jaeyeonling.racingcar.exception;

public class MovingCountShorterThanMinException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "movingCount 값은 %d 이하가 될 수 없습니다. (입력 값: %d)";

    public static final int MINIMUM_MOVING_COUNT = 0;

    public MovingCountShorterThanMinException(final int input) {
        super(String.format(ERROR_MESSAGE, MINIMUM_MOVING_COUNT, input));
    }
}