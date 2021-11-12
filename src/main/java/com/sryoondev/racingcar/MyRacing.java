package com.sryoondev.racingcar;

public class MyRacing {
    private MyCar[] myCars;
    private final int racingCount;

    public MyRacing(int carCount, int racingCount) {
        myCars = new MyCar[carCount];
        this.racingCount = racingCount;
    }

    public int getCarCount() {
        return myCars.length;
    }

    public int getRacingCount() {
        return this.racingCount;
    }
}
