package service.impl;

import service.MoveRule;

import java.util.Random;

public class RandomMoveRule implements MoveRule {

    private final Random random;
    private static final int RANDOM_INTEGER_BOUNDED = 10;
    private static final int MIN_MOVE_RANDOM_NUMBER = 4;

    public RandomMoveRule(Random random) {
        this.random = random;
    }

    public RandomMoveRule() {
        this.random = new Random();
    }

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_INTEGER_BOUNDED) >= MIN_MOVE_RANDOM_NUMBER;
    }

}
