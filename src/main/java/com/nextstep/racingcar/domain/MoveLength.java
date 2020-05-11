package com.nextstep.racingcar.domain;

public class MoveLength {
    private final int value;

    private MoveLength(int value) {
        this.value = value;
    }

    public static MoveLength createZero() {
        return new MoveLength(0);
    }

    protected static MoveLength createByInt(int value) {
        return new MoveLength(value);
    }

    public int toInt() {
        return this.value;
    }
}
