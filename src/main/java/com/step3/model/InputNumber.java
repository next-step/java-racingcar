package com.step3.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputNumber that = (InputNumber) o;
        return carCount == that.carCount &&
                attemptCount == that.attemptCount;
    }
}
