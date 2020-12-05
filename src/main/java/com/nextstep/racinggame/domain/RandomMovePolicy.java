package com.nextstep.racinggame.domain;

import java.util.Random;

public class RandomMovePolicy implements MovePolicy {
    private static final int RANDOM_RANGE = 10;
    private static final int CAN_MOVE_BOUNDARY = 4;

    private static final Random RANDOM = new Random();

    @Override
    public boolean canMove() {
        return RANDOM.nextInt(RANDOM_RANGE) >= CAN_MOVE_BOUNDARY;
    }
}
