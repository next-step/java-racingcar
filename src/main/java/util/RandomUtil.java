package util;

import java.util.Random;

public class RandomUtil {

    private final static int RANDOM_RANGE = 10;
    private final static Random random = new Random();

    public static int getRandomValuelessThenTen() {
        return random.nextInt(RANDOM_RANGE);
    }
}
