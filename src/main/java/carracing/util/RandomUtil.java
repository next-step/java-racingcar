package carracing.util;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();
    private static final int RANDOM_BOUND = 10;
    private static final int CRITERIA_FOR_WIN = 4;

    public static boolean forward() {
        return random.nextInt(RANDOM_BOUND) >= CRITERIA_FOR_WIN;
    }

}
