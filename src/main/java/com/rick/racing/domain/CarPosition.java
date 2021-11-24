package com.rick.racing.domain;

import java.util.Objects;

public class CarPosition implements Comparable<CarPosition> {

    private static final int INITIAL_VALUE = 0;

    private int value;

    public CarPosition(final int initialValue) {
        value = initialValue;
    }

    public static CarPosition create() {
        return new CarPosition(INITIAL_VALUE);
    }

    public static CarPosition create(final int value) {
        return new CarPosition(value);
    }

    public void increase() {
        value++;
    }

    public int asInt() {
        return value;
    }

    @Override
    public boolean equals(final Object target) {
        if (this == target) {
            return true;
        }
        if (target == null || getClass() != target.getClass()) {
            return false;
        }
        CarPosition that = (CarPosition) target;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(final CarPosition target) {
        return this.value - target.value;
    }
}
