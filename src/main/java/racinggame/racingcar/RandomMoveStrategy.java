package racinggame.racingcar;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int FORWARD_THRESHOLD = 4;
    private static final int MAX_RANDOM_VALUE = 10;
    private final Random random;

    public RandomMoveStrategy() {
        this.random = new Random();
    }

    @Override
    public boolean shouldMove() {
        return random.nextInt(MAX_RANDOM_VALUE) >= FORWARD_THRESHOLD;
    }
}
