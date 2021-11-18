package racingcargamefinal.utils;

import java.util.Random;

public class RandomUtils {

    private static final int RANDOM_BOUND = 10;
    private static final Random RANDOM = new Random();

    public static int getRandomValue() {
        return RANDOM.nextInt(RANDOM_BOUND);
    }

}
