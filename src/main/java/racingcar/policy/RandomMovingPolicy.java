package racingcar.policy;

import java.util.Random;

public class RandomMovingPolicy implements MovingPolicy{
    private final Random random = new Random();
    private static final int DEFAULT_MOVE_CONDITION = 4;
    private static final int DEFAULT_MAX_RANGE = 10;

    public RandomMovingPolicy() { }

    @Override
    public boolean isPossibleMove() {
        return random.nextInt(DEFAULT_MAX_RANGE) >= DEFAULT_MOVE_CONDITION;
    }
}
