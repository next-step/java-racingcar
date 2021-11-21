package com.step3.model.car.strategy;

import com.step3.util.RandomUtil;

public class CarMoveStrategy implements MoveStrategy {
    private static final int MOVE_POSSIBLE_BOUND = 4;

    @Override
    public boolean isMove(int randomValue) {
        return randomValue > MOVE_POSSIBLE_BOUND;
    }
}
