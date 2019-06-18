package com.jaeyeonling.exception;

public class MovingCountLongerThanMaxException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "movingCount 값은 %d 이상이 될 수 없습니다. (입력 값: %d)";

    public static final int MAXIMUM_MOVING_COUNT = 10_000;

    public MovingCountLongerThanMaxException(final int input) {
        super(String.format(ERROR_MESSAGE, MAXIMUM_MOVING_COUNT, input));
    }
}