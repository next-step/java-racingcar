package racingcar.strategy;

import java.util.Objects;
import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_LIMIT = 10;
    private static final int MOVE_STANDARD = 4;
    public static final MoveStrategy DEFAULT_MOVE_STRATEGY = from(new Random(RANDOM_LIMIT));

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

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean isMovable() {
        int randomNumber = random.nextInt(RANDOM_LIMIT);

        return randomNumber >= 0 &&
                randomNumber < RANDOM_LIMIT &&
                randomNumber >= MOVE_STANDARD;
    }
}
