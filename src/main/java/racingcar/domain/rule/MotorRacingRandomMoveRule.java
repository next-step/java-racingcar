package racingcar.domain.rule;

import java.util.Random;

class MotorRacingRandomMoveRule implements MotorRacingRule {
    public static final int RACE_CONDITION = 4;
    public static final int RACE_MOVE_BOUND = 10;
    private final Random random;

    public MotorRacingRandomMoveRule() {
        random = new Random();
    }

    @Override
    public boolean pass() {
        return RACE_CONDITION >= getRaceConditionRange();
    }

    int getRaceConditionRange() {
        return random.nextInt(RACE_MOVE_BOUND);
    }
}
