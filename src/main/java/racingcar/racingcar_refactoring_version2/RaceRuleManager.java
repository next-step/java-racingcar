package racingcar.racingcar_refactoring_version2;

import java.util.Random;

public class RaceRuleManager {
    private static final int RULE_COUNT = 10;
    private static final int RUNNABLE_RULE_COUNT = 3;

    public boolean canMove() {
        return new Random().nextInt(RULE_COUNT) > RUNNABLE_RULE_COUNT;
    }
}
