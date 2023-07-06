package car.util;

import java.util.Random;

public final class NumberGenerator {

    private static final int NUMBER_LIMIT = 10;

    public static int getRandomNumber() {
        return new Random().nextInt(NUMBER_LIMIT);
    }
}
