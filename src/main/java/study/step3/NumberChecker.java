package study.step3;

import java.util.Random;

public class NumberChecker {
    public static final Integer RANDOM_BOUND = 10;
    public static final Integer CONDITION_OF_START = 4;
    public static boolean checkCondition() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND) >= CONDITION_OF_START;
    }
}
