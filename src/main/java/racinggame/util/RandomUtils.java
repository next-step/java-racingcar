package racinggame.util;

import java.util.Random;

public class RandomUtils {

    private static final Random rd = new Random();

    private RandomUtils() {
    }

    public static int randomNumber(int maxRandomNumber) {
        return rd.nextInt(maxRandomNumber);
    }
}
