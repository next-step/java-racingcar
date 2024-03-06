package racingcar;

import java.util.Random;

public class DrivingStrategyImpl implements DrivingStrategy {

    private final Random random = new Random();

    @Override
    public boolean canDrive() {
        return random.nextInt(10) >= 4;
    }
}
