package step5.util;

import java.util.Random;

public class CarUtils {
    private static final Random random = new Random();
    private static final int CAR_MOVE_MAX_BOUND = 10;

    public static int getRandom() {
        return random.nextInt(CAR_MOVE_MAX_BOUND);
    }
}
