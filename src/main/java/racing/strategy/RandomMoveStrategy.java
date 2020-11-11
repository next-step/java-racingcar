package racing.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;

    @Override
    public boolean isMoveable() {
        return getRandomNumber() >= FORWARD_NUM;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
