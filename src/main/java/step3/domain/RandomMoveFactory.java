package step3.domain;

import java.util.Random;

public class RandomMoveFactory {

    private static final Random random = new Random();

    private static final int RANDOM_MAX_RANGE = 10;
    private static final int MOVEABLE_TARGET_VALUE = 4;

    public static MoveStrategy getInstance() {
        if (random.nextInt(RANDOM_MAX_RANGE) < MOVEABLE_TARGET_VALUE) {
            return new StopMoveStrategy();
        }

        return new ForwardMoveStrategy();
    }
}
