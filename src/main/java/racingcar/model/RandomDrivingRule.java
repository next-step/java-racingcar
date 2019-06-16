package racingcar.model;

import java.util.Random;

public class RandomDrivingRule implements DrivingRule {
    private static final int RANDOM_VALUE_BOUNDARY = 10;
    private static final int MOVEMENT_CRITERIA = 4;

    private Random random;

    private RandomDrivingRule() {
        random = new Random();
    }

    public static RandomDrivingRule getInstance() {
        return DrivingRuleHolder.INSTANCE;
    }

    private static class DrivingRuleHolder {
        private static final RandomDrivingRule INSTANCE = new RandomDrivingRule();
    }

    @Override
    public boolean isMovable() {
        int discriminantValue = random.nextInt(RANDOM_VALUE_BOUNDARY);
        return discriminantValue >= MOVEMENT_CRITERIA;
    }
}
