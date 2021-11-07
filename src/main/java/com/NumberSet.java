package com;

public class NumberSet {
    private int carCount;
    private int attemptCount;

    public NumberSet(int carCount, int attemptCount) {
        this.carCount = carCount;
        this.attemptCount = attemptCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
