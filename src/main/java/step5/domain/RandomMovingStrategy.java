package step5.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final Random random = new Random();

    private static final int MINIMUM_MOVABLE_VALUE = 4;
    private static final int MAX_BOUND = 10;

    @Override
    public boolean isMovable() {
        return createRandomNumber() >= MINIMUM_MOVABLE_VALUE;
    }

    private int createRandomNumber() {
        return random.nextInt(MAX_BOUND);
    }

}
