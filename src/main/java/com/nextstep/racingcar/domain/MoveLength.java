package com.nextstep.racingcar.domain;

public class MoveLength {
    private final int value;

    private MoveLength(int value) {
        this.value = value;
    }

    public static MoveLength createZero() {
        return new MoveLength(0);
    }

    public int toInt() {
        return this.value;
    }
}
