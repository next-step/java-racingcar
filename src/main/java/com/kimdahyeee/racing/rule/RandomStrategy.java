package com.kimdahyeee.racing.rule;

import java.util.Random;

public class RandomStrategy implements MovableStrategy {
    private static final int RANDOM_BOUND = 10;
    private static final int GO_STRAIGHT_LIMIT = 4;
    private static final Random random = new Random();

    @Override
    public boolean canMove() {
        return random.nextInt(RANDOM_BOUND) >= GO_STRAIGHT_LIMIT;
    }
}
