package step3;

import java.util.Random;

public class RandomMoveFactory {

    private static final Random random = new Random();

    private static final int RANDOM_MAX_VALUE = 10;

    private static final int START_MOVE_MIN_VALUE = 4;

    public static MoveStrategy getInstance() {
        if (random.nextInt(RANDOM_MAX_VALUE) < START_MOVE_MIN_VALUE) {
            return new StopMoveStrategy();
        }

        return new ForwardMoveStrategy();
    }
}
