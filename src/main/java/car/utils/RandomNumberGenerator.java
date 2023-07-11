package car.utils;

import java.util.Random;

public final class RandomNumberGenerator {

    private static final int NUMBER_LIMIT = 10;

    public static int getRandomNumber() {
        Random ran = new Random();
        return ran.nextInt(NUMBER_LIMIT);
    }

}
