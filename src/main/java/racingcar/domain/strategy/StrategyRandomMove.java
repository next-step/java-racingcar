package racingcar.domain.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class StrategyRandomMove implements MoveStrategy{
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    private static final int RANDOM_BOUND = 10;
    private static final int MOVABLE_STANDARD_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return getNumber() >= MOVABLE_STANDARD_NUMBER;
    }

    private int getNumber() {
        return random.nextInt(RANDOM_BOUND);
    }
}
