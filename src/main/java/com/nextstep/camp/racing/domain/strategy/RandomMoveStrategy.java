package com.nextstep.camp.racing.domain.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private final Random random = new Random();
    private static final int BOUND = 10;
    private static final int THRESHOLD = 4;

    public static final RandomMoveStrategy INSTANCE = new RandomMoveStrategy();

    @Override
    public boolean movable() {
        return random.nextInt(BOUND) > THRESHOLD;
    }
}
