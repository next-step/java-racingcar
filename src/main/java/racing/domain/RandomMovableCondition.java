package racing.domain;

import java.util.Random;

public class RandomMovableCondition implements Movable {
    private final Random RANDOM = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MIN_MOVABLE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return createRandomNumber() >= MIN_MOVABLE_NUMBER;
    }

    private int createRandomNumber() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUND);
    }
}
