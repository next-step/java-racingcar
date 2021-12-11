package racingcar.domain.movingstrategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int RANDOM_INT_BOUND = 10;
    private static final int NUMBER_SHOUL_BE_EXCEEDED = 3;

    private static final Random random = new Random();

    private static final RandomMovingStrategy INATANCE = new RandomMovingStrategy();

    private RandomMovingStrategy() {}

    public static RandomMovingStrategy getInatance() {
        return INATANCE;
    }

    @Override
    public boolean movable() {
        return random.nextInt(RANDOM_INT_BOUND) > NUMBER_SHOUL_BE_EXCEEDED;
    }

}
