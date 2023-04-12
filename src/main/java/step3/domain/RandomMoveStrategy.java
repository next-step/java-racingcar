package step3.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;
    private static final int RANDOM_NUMBER = 10;
    private static Random RANDOM = new Random();

    @Override
    public boolean isMovable() {
        return randomGenerator() >= MOVE_CONDITION;
    }

    @Override
    public int randomGenerator() {
        return RANDOM.nextInt(RANDOM_NUMBER);
    }
}
