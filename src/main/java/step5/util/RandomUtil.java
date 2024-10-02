package step5.util;

import java.util.Random;

public class RandomUtil {

    private final static int RANDOM_RANGE = 10;
    private final static Random RANDOM = new Random();

    public static int getRandomValuelessThenTen() {
        return RANDOM.nextInt(RANDOM_RANGE);
    }
}
