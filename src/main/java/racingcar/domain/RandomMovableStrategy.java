package racingcar.domain;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {

    private static final int RANDOM_VALUE_MAXIMUM_AMOUNT = 9;
    private static final int MOVE_CONDITION_MAXIMUM_VALUE = 4;

    private static final Random RANDOM = new Random();

    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(RANDOM_VALUE_MAXIMUM_AMOUNT) >= MOVE_CONDITION_MAXIMUM_VALUE;
    }
}
