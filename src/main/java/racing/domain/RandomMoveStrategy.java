package racing.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{
    private static final int MOVABLE_NUMBER = 4;
    private static final int RANDOM_RANGE = 10;

    private final Random randomGenerator = new Random();

    @Override
    public boolean isMovable() {
        final int randomNumber = randomGenerator.nextInt(RANDOM_RANGE);
        return randomNumber >= MOVABLE_NUMBER;
    }
}
