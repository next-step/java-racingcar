package racingcar.domain;

import java.util.Random;
import racingcar.domain.DrivingStrategy;

public class SixtyPercentRandomDrivingStrategy implements DrivingStrategy {

    private static final int RANGE_UPPER_BOUND = 10;
    private static final int THRESHOLD = 4;

    private static final Random RANDOM = new Random();

    @Override
    public boolean canDrive() {
        return RANDOM.nextInt(RANGE_UPPER_BOUND) >= THRESHOLD;
    }
}
