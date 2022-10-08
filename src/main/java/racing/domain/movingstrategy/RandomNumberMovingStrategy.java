package racing.domain.movingstrategy;

import java.util.Random;

public class RandomNumberMovingStrategy implements MovingStrategy {

    private static final int BOUND = 10;
    private static final int MOVABLE_LIMIT = 4;
    private final Random random = new Random();

    @Override
    public boolean isMovable() {
        return generateRandomNumber() > MOVABLE_LIMIT;
    }

    private int generateRandomNumber() {
        return random.nextInt(BOUND);
    }
}
