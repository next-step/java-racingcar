package com.nextstep.camp.racing.domain.strategy;

@FunctionalInterface
public interface MoveStrategy {

    static MoveStrategy when(MoveStrategy strategy) {
        return strategy;
    }

    boolean movable();
}
