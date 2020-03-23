package racingcar.policy;

import java.util.Random;

public class RandomMovingPolicy implements MovingPolicy{
    private final Random random = new Random();
    private static final int POSSIBLE_MIN_MOVE_CONDITION = 4;
    private static final int DEFAULT_MAX_RANGE = 10;
    private int minRange;
    private int maxRange;

    public RandomMovingPolicy() {
        this(POSSIBLE_MIN_MOVE_CONDITION, DEFAULT_MAX_RANGE);
    }

    public RandomMovingPolicy(final int minRange, final int maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    @Override
    public boolean isPossibleMove(int distance) {
        return minRange <= distance && distance < maxRange;
    }

    @Override
    public int distance() {
        return random.nextInt(maxRange - minRange) + minRange;
    }
}
