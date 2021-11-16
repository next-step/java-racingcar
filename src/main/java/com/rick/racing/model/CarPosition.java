package com.rick.racing.model;

import java.util.Objects;

public class CarPosition implements Comparable<CarPosition> {

    private int value;

    public CarPosition(int initialValue) {
        value = initialValue;
    }

    public static CarPosition create(int initialValue) {
        return new CarPosition(initialValue);
    }

    public void increase() {
        value++;
    }

    public int asInt() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPosition that = (CarPosition) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(CarPosition o) {
        return this.value - o.value;
    }
}
