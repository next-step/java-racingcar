package step3.domain;

import java.util.Random;

public class RacingRule {

    private static final int RACE_CONDITION_BASE_VALUE = 10;
    private static Random random = new Random();
    public static int MOVEMENT_POLICY = 3;

    public static int raceCondition() {
        return random.nextInt(RACE_CONDITION_BASE_VALUE);
    }

}
