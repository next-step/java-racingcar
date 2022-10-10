package racingcar.winner.model;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {
    private final Random random = new Random();
    private static final int RANDOM_UPPER_BOUND_EXCLUSIVE = 10;

    @Override
    public boolean canMove() {
        return GameRule.canMove(random.nextInt(RANDOM_UPPER_BOUND_EXCLUSIVE));
    }
}
