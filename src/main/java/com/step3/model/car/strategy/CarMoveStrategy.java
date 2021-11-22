package com.step3.model.car.strategy;

import com.step3.util.RandomUtil;

public class CarMoveStrategy implements MoveStrategy {
    private static final int MOVE_POSSIBLE_BOUND = 4;

    @Override
    public boolean isMove() {
        return RandomUtil.getRandomValue() > MOVE_POSSIBLE_BOUND;
    }
}
