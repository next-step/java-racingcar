package racingcar.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVABLE_RANDOM_SEED = 10;
    private static final int MOVABLE_DECISION_FACTOR = 4;

    private final Random random = new Random();
    public boolean strategicMove() {
        return random.nextInt(MOVABLE_RANDOM_SEED) >= MOVABLE_DECISION_FACTOR;
    }
}
