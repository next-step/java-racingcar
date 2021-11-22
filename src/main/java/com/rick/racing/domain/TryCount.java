package com.rick.racing.domain;

public class TryCount {

    public static final int MIN_TRY_COUNT = 1;
    private static final String EXCEPTION_MESSAGE_MINIMUM_TRY_COUNT = "시도 수는 0보다 커야 합니다.";

    private final int value;

    private TryCount(final int count) {
        this.value = count;
    }

    public static TryCount create(final int value) {
        if (value <= MIN_TRY_COUNT) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MINIMUM_TRY_COUNT);
        }
        return new TryCount(value);
    }

    public int asInt() {
        return value;
    }
}
