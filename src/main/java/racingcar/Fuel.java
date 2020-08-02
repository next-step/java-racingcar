package racingcar;

import java.util.Random;

public class Fuel {

    private static final Random random = new Random();
    private static final int RANDOM_RANGE = 10;

    public static int inject() {
        return random.nextInt(RANDOM_RANGE);
    }
}
