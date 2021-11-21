package com.step3.model;

import java.util.Arrays;

public class InputNumber {
    private final String[] carsName;
    private final int attemptCount;

    public InputNumber(String[] carsName, int attemptCount) {
        this.carsName = carsName;
        this.attemptCount = attemptCount;
    }

    public String[] getCarsName() {
        return carsName;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InputNumber that = (InputNumber) o;
        return Arrays.deepEquals(carsName, this.carsName) &&
                attemptCount == that.attemptCount;
    }
}
