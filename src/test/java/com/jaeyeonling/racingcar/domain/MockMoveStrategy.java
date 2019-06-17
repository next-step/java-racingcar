package com.jaeyeonling.racingcar.domain;

import java.util.List;

class MockMoveStrategy implements MoveStrategy {

    private final List<Boolean> movingConditions;
    private int currentIndex;

    MockMoveStrategy(final List<Boolean> movingConditions) {
        this.movingConditions = movingConditions;
    }

    @Override
    public boolean isMove(int ignore) {
        return movingConditions.get(currentIndex++);
    }
}
