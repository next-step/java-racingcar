package com.rick.racing.model;

public class RacingPlayData {

    public static final String EXCEPTION_MESSAGE_MINIMUM_CAR_COUNT = "차 대수는 0보다 커야 합니다.";
    public static final String EXCEPTION_MESSAGE_MINIMUM_TRY_COUNT = "시도 수는 0보다 커야 합니다.";
    private final int carCount;
    private final int tryCount;

    public RacingPlayData(int carCount, int tryCount) {
        if(carCount <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MINIMUM_CAR_COUNT);
        }

        if(tryCount <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MINIMUM_TRY_COUNT);
        }

        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int carCount() {
        return carCount;
    }

    public int tryCount() {
        return tryCount;
    }
}
