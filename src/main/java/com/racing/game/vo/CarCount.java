package com.racing.game.vo;

public class CarCount {
    private final int value;

    private CarCount(int value) {
        this.value = value;
    }

    public static CarCount of(int value) {
        return new CarCount(value);
    }

    public int value() {
        return value;
    }
}
