package com.racing.game.vo;

public class TryCount {
    private final int value;

    private TryCount(int value) {
        this.value = value;
    }

    public static TryCount of(int value) {
        return new TryCount(value);
    }

    public int value() {
        return value;
    }
}
