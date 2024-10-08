package javaracingcarwinner.entity;

import java.util.Random;

public class Move implements MoveStrategy {
    private static final int RANDOM_RANGE = 10;
    private static final Random random = new Random();

    @Override
    public int movingValue() {
        return random.nextInt(RANDOM_RANGE);
    }
}
