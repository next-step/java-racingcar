package com.cheolhyeonpark.step4.domain;

import java.util.Random;

public class Dice implements MovingStrategy {

    public static final int RANDOM_BOUND = 10;
    public static final int MINIMUM_MOVABLE_DICE_NUMBER = 4;

    private final Random random = new Random();

    public int rollDice() {
        return random.nextInt(RANDOM_BOUND);
    }

    @Override
    public boolean isMovable() {
        return rollDice() >= MINIMUM_MOVABLE_DICE_NUMBER;
    }
}
