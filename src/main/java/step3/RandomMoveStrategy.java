package step3;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        return getRandomNumber() >= MOVE_THRESHOLD;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
