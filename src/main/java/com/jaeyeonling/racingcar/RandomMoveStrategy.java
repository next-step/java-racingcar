package com.jaeyeonling.racingcar;

import com.jaeyeonling.racingcar.utils.RandomUtils;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_BOUND = 9;

    @Override
    public boolean isMove() {
        return RandomUtils.getIntWithBound(RANDOM_BOUND) >= 4;
    }
}
