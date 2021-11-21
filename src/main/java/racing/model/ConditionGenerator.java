package racing.model;

import java.util.Random;

/**
 * .
 */
public class ConditionGenerator {
    private static final int LIMIT = 10;
    private static final Random RANDOM = new Random();

    public static int generate() {
        return RANDOM.nextInt(LIMIT);
    }
}
