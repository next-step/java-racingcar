package racingcar;

import java.util.Random;

public class DrivingStrategyImpl implements DrivingStrategy {

    private static final int RANGE_UPPER_BOUND = 10;
    private static final int THRESHOLD = 4;

    private static final Random random = new Random();

    @Override
    public boolean canDrive() {
        return random.nextInt(RANGE_UPPER_BOUND) >= THRESHOLD;
    }
}
