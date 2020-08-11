package racing.util;

import java.util.Random;

public class RandomUtil {
    private static final int RANDOM_MAX_NUM = 10;

    public static int getRandomNum() {
        return new Random().nextInt(RANDOM_MAX_NUM);
    }
}
