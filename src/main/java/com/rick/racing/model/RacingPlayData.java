package com.rick.racing.model;

public class RacingPlayData {

    private final int carCount;
    private final int tryCount;

    public RacingPlayData(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
