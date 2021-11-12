package com.sryoondev.racingcar;

public class MyRacing {
    private final int carCount;
    private final int racingCount;

    public MyRacing(int carCount, int racingCount) {
        this.carCount = carCount;
        this.racingCount = racingCount;
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getRacingCount() {
        return this.racingCount;
    }
}
