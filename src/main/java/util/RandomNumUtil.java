package util;

import java.util.Random;

public class RandomNumUtil {

    private static final int RANDOM_BOUND = 10;
    private static Random random = new Random();

    public static int makeRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }

}
