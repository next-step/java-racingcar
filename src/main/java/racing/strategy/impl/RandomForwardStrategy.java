package racing.strategy.impl;

import racing.strategy.MoveStrategy;

import java.util.Random;

public class RandomForwardStrategy implements MoveStrategy {
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int THRESHOLD_ONGOING = 4;
    private static final Random rnd = new Random();

    public boolean move() {
        return random();
    }

    private boolean random() {
        return rnd.nextInt(MAX_RANDOM_VALUE + 1) >= THRESHOLD_ONGOING;
    }
}