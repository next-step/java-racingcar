package racingcar;

import java.util.Random;

public class RandomNum {
    private static final Random random = new Random();
    private static final int RANDOM_BOUND = 10;

    public static int makeRandomNum() {
        return random.nextInt(RANDOM_BOUND);
    }
}
