package com.nextstep.camp.racing.domain.vo;

public class Move {
    private final boolean value;

    private Move(boolean value) {
        this.value = value;
    }

    public static Move of(boolean value) {
        return new Move(value);
    }

    public boolean isMove() {
        return value;
    }
}
