package com.jaeyeonling.racingcar.exception;

public class BoundNegativeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "bound 값은 양수만 가능합니다. (입력 값: %d)";

    public static final int MINIMUM_BOUND = 1;

    public BoundNegativeException(final int input) {
        super(String.format(ERROR_MESSAGE, input));
    }
}
