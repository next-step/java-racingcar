package racingcar.domain;

import java.util.Random;

class MotorRacingRandomMoveRule implements MotorRacingRule {
    public static final int RACE_CONDITION = 4;
    private final Random random;

    public MotorRacingRandomMoveRule() {
        random = new Random();
    }

    @Override
    public boolean pass() {
        return RACE_CONDITION >= getRaceConditionRange();
    }

    int getRaceConditionRange() {
        return random.nextInt(10);
    }
}
