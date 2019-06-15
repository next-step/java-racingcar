package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.racingcar.utils.RandomUtils;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVING_RANDOM_BOUND = 9;
    private static final int MORE_THAN_MOVING_CONDITION = 4;

    @Override
    public boolean isMove() {
        return RandomUtils.getIntWithBound(MOVING_RANDOM_BOUND) >= MORE_THAN_MOVING_CONDITION;
    }
}
