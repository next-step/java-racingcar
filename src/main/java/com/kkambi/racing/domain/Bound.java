package com.kkambi.racing.domain;

public enum Bound {

    ROLL(10),
    MIN_MOVE(4);

    private final int value;

    Bound(int bound) {
        this.value = bound;
    }

    public int getValue() {
        return value;
    }
}
