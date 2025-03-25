package racing.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random random = new Random();
    private static final int CAR_MOVE_BOUND = 10;

    public static int generateRandomNumber() {
        return random.nextInt(CAR_MOVE_BOUND);
    }
}
