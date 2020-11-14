package racingcar.util;

import java.util.Random;

public class CarRandom {
    private static final Random random = new Random();
    private static final int MAX_MOVING_BOUNDARY = 10;

    public static int makeRandomValue() {
        return random.nextInt(MAX_MOVING_BOUNDARY);
    }
}
