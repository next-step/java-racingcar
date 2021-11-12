package domain;

import java.util.Random;

public class Driving {
    private static final int RANDOM_NUMBER_MAX = 10;
    private static final int MOVING_STANDARD_NUMBER = 4;
    private static final int STOP_NUMBER = 0;
    private static final int MOVING_NUMBER = 1;
    private static final Random random = new Random();

    private Driving() {
    }

    public static int driving() {
        if (Driving.createRandomNumber() >= MOVING_STANDARD_NUMBER) {
            return MOVING_NUMBER;
        }
        return STOP_NUMBER;
    }

    public static int createRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_MAX);
    }
}
