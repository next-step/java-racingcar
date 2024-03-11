package common;

import java.util.Random;

public class RandomUtil {

    private static final int RANGE = 10;

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANGE);
    }
}

