package racingcar;

import java.util.Random;

public class MoveStrategyImpl implements MoveStrategy {
    public static final int MOVEMENT_UNIT = 1;
    public static final int THRESHOLD = 4;
    public static final int BOUND = 10;
    private static final Random random = new Random();

    @Override
    public int getMovement() {
        if (random.nextInt(BOUND) >= THRESHOLD)
            return MOVEMENT_UNIT;
        return 0;
    }
}
