package CarRacing.domain;

import java.util.Random;

public class MovingStrategyRandom implements MovingStrategy {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int RANDOM_NUMBER_BOUND_FOR_MOVING = 4;
    private static final int DISTANCE_STOP = 0;

    private final Random random = new Random();

    @Override
    public int movable(int number) {
        if ((random.nextInt(RANDOM_NUMBER_BOUND)) >= RANDOM_NUMBER_BOUND_FOR_MOVING) {
            return number;
        }

        return DISTANCE_STOP;
    }
}
