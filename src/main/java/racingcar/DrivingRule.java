package racingcar;

import java.util.Random;

public class DrivingRule {
    private static final int RANDOM_VALUE_BOUNDARY = 10;
    private static final int MOVEMENT_CRITERIA = 4;

    private Random random;

    private DrivingRule() {
        random = new Random();
    }

    public static DrivingRule getInstance() {
        return DrivingRuleHolder.INSTANCE;
    }

    private static class DrivingRuleHolder {
        private static final DrivingRule INSTANCE = new DrivingRule();
    }

    public boolean isMovable() {
        int discriminantValue = random.nextInt(RANDOM_VALUE_BOUNDARY);
        return discriminantValue >= MOVEMENT_CRITERIA;
    }
}
