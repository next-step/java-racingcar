package com.nextstep.camp.racing.domain.vo;

import com.nextstep.camp.racing.domain.strategy.MoveStrategy;

public class Move {
    private final boolean value;

    private Move(MoveStrategy strategy) {
        this.value = strategy.movable();
    }

    public static Move decide(MoveStrategy strategy) {
        return new Move(strategy);
    }

    public static Move of(boolean value) {
        return new Move(() -> value);
    }

    public boolean isMove() {
        return value;
    }
}
