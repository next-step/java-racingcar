package com.nextstep.racingcar.domain;

public class MoveLength {
    private static final int MIN_VALUE = 0;
    private final int value;

    private MoveLength(int value) {
        validation(value);
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

    private void validation(int value) {
        if (value < MIN_VALUE) throw new IllegalArgumentException();
    }
}
