package com.jaenyeong.mission2.racingcar.domain;

public enum Move {
    NEXT(1), STOP(0),
    RANDOM_START_RANGE(0), RANDOM_END_RANGE(9),
    MOVE_LIMIT_WHEN_RANDOM(4);

    private final int value;

    Move(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
