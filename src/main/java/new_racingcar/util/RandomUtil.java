package new_racingcar.util;

import java.util.Random;

public class RandomUtil {
    private static final int RANDOM_SIZE = 10;

    private static Random random = new Random();

    public static int getValue() {
        return random.nextInt(RANDOM_SIZE);
    }
}
