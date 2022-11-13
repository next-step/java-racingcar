package strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVABLE_MINIMUM_VALUE = 4;
    private static final int RANDOM_VALUE_RANGE = 10;
    private static final Random RANDOM_GENERATOR = new Random();

    @Override
    public boolean isMovable() {
        if (MOVABLE_MINIMUM_VALUE <= getRandomNumber()) {
            return true;
        }
        return false;
    }

    public int getRandomNumber() {
        return RANDOM_GENERATOR.nextInt(RANDOM_VALUE_RANGE);
    }
}
