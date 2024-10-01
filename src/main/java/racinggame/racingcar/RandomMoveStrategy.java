package racinggame.racingcar;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int FORWARD_THRESHOLD = 4;
    private final Random random;

    RandomMoveStrategy() {
        this.random = new Random();
    }

    @Override
    public boolean shouldMove() {
        return random.nextInt(10) >= FORWARD_THRESHOLD;
    }
}
