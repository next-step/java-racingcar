package racingcar.strategy;

import java.util.Objects;
import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_LIMIT = 10;
    private static final int MOVE_STANDARD = 4;

    private final Random random;

    private RandomMoveStrategy(Random random) {
        validate(random);

        this.random = random;
    }

    public static RandomMoveStrategy from(Random random) {
        return new RandomMoveStrategy(random);
    }

    private void validate(Random random) {
        if (Objects.isNull(random)) {
            throw new IllegalArgumentException("Random can't be null");
        }
    }

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_LIMIT) >= MOVE_STANDARD;
    }
}
