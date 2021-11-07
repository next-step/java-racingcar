package com.step3.model;

public class InputNumber {
    private int carCount;
    private int attemptCount;

    public InputNumber(int carCount, int attemptCount) {
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
