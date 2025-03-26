package step4.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    public static final int BOUND = 10;
    public static final int THRESHOLD = 4;
    private final Random random;

    public RandomMoveStrategy(Random random) {
        this.random = random;
    }
    @Override
    public boolean isMovable() {
        return random.nextInt(BOUND) >= THRESHOLD;
    }
}
