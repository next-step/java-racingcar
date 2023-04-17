package step4.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;
    private static final int RANDOM_NUMBER = 10;

    @Override
    public boolean isMovable() {
        return randomGenerator() >= MOVE_CONDITION;
    }

    @Override
    public int randomGenerator() {
        return ThreadLocalRandom.current().nextInt(RANDOM_NUMBER);
    }
}
