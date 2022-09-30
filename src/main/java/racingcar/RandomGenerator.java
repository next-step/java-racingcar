package racingcar;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();
    private static final int MAX_NUM = 10;

    public static int randomInt() {
        return random.nextInt(MAX_NUM);
    }
}
