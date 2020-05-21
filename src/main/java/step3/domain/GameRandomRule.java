package step3.domain;

import java.util.Random;

public class GameRandomRule implements GameRule {

    private static final Random random = new Random();

    private static final int RANDOM_MAX_RANGE = 10;
    private static final int MOVEABLE_TARGET_VALUE = 4;

    public GameRandomRule() {
    }

    public boolean isMovable() {
        return MOVEABLE_TARGET_VALUE <= random.nextInt(RANDOM_MAX_RANGE);
    }
}
