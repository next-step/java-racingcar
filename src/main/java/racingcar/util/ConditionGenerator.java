package racingcar.util;

import java.util.Random;

public class ConditionGenerator {

    private static ConditionGenerator conditionGenerator = new ConditionGenerator();

    private static final int BOUND = 10;
    private final Random random;

    private ConditionGenerator() {
        random = new Random();
    }

    public static ConditionGenerator getInstance() {
        return conditionGenerator;
    }

    public int generateRandomCondition() {
        return random.nextInt(BOUND);
    }
}
