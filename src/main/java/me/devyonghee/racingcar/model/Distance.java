package me.devyonghee.racingcar.model;

public final class Distance {

    private final int value;

    private Distance(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("distance must be greater than zero");
        }
        this.value = value;
    }

    public static Distance from(int value) {
        return new Distance(value);
    }

    public int value() {
        return value;
    }
}
