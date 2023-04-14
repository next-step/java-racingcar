package racing.carRacing.service;

import java.util.Random;

public class RandomMovementStrategy implements MovementStrategy {
    public static final Random RANDOM = new Random(System.currentTimeMillis());
    public static final int MAX_VALUE = 9;
    public static final int BOUNDARY = MAX_VALUE + 1;
    public static final int CONDITION = 4;

    @Override
    public boolean movement() {
        return RANDOM.nextInt(BOUNDARY) >= CONDITION;
    }
}
