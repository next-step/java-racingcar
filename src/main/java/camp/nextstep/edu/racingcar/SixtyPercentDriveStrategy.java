package camp.nextstep.edu.racingcar;

import java.util.Random;

public class SixtyPercentDriveStrategy implements DriveStrategy {

    private static final int TOTAL_PROBABILITY = 10;
    private static final int MINIMUM_SUCCESS_THRESHOLD = 4;

    private final Random random;

    public SixtyPercentDriveStrategy() {
        this.random = new Random();
    }

    @Override
    public boolean canDrive() {
        int randomZeroToNine = random.nextInt(TOTAL_PROBABILITY);
        return randomZeroToNine >= MINIMUM_SUCCESS_THRESHOLD;
    }
}
