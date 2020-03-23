package racingcar.policy;

import java.util.Random;

public class RandomMovingPolicy implements MovingPolicy{
    private final Random random = new Random();
    private static final int DEFAULT_MOVE_CONDITION = 4;
    private static final int DEFAULT_MIN_VALUE = 0;
    private static final int DEFAULT_MAX_RANGE = 10;
    private int minRange;
    private int maxRange;
    private int condition;

    public RandomMovingPolicy() {
        this(DEFAULT_MIN_VALUE, DEFAULT_MAX_RANGE, DEFAULT_MOVE_CONDITION);
    }

    public RandomMovingPolicy(final int minRange, final int maxRange, final int condition) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.condition = condition;
    }

    @Override
    public boolean isPossibleMove(int distance) {
        return condition <= distance && distance < maxRange;
    }

    @Override
    public int distance() {
        return random.nextInt(maxRange - minRange) + minRange;
    }
}
