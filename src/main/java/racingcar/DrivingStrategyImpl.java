package racingcar;

import java.util.Random;

public class DrivingStrategyImpl implements DrivingStrategy {

    public static final int RANGE_UPPER_BOUND = 10;
    public static final int THRESHOLD = 4;

    private final Random random = new Random();

    @Override
    public boolean canDrive() {
        return random.nextInt(RANGE_UPPER_BOUND) >= THRESHOLD;
    }
}
