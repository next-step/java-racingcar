package racingcar.domain;

import java.util.Random;

public class RuleStrategyImpl implements RuleStrategy {
    public static final int NO_MOVEMENT = 0;
    public static final int MOVEMENT_UNIT = 1;
    public static final int THRESHOLD = 4;
    public static final int BOUND = 10;
    private static final Random random = new Random();

    @Override
    public int getMovement() {
        if (random.nextInt(BOUND) >= THRESHOLD)
            return MOVEMENT_UNIT;

        return NO_MOVEMENT;
    }
}
