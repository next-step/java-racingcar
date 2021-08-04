package carracing.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MOVE_THRESHOLD = 3;

    private final Random random;

    private RandomMoveStrategy(Random random) {
        this.random = random;
    }

    public static MoveStrategy of(Random random) {
        return new RandomMoveStrategy(random);
    }

    @Override
    public boolean movable() {
        return random.nextInt(RANDOM_NUMBER_BOUND) > MOVE_THRESHOLD;
    }
}
