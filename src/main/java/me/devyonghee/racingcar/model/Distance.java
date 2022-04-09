package me.devyonghee.racingcar.model;

import java.util.Objects;

public final class Distance {

    public static final Distance ZERO = Distance.from(0);
    public static final Distance ONE = Distance.from(1);

    private final int value;

    private Distance(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format("distance(%d) must be greater than zero", value));
        }
        this.value = value;
    }

    public static Distance from(int value) {
        return new Distance(value);
    }

    public Distance add(Distance distance) {
        return from(value + distance.value);
    }

    public int value() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "value=" + value +
                '}';
    }
}
