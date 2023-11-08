package step4.model;

import java.util.Random;

public class Rule {

    private static final Random random = new Random();
    private static final int MAX_RANDOM_VALUE = 10;
    private static final int MINIMUM_RANDOM_VALUE = 4;

    public static boolean isCarMovable(int randomValue) {
        return randomValue >= MINIMUM_RANDOM_VALUE;
    }

    public static int getRandomValue() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}
