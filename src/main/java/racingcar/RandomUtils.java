package racingcar;

import java.util.Random;

public class RandomUtils {
    private static final int RANDOM_NUMBER_BOUNDARY = 10;
    private static final Random random = new Random();

    public static int generateRandomNum() {
        return random.nextInt(RANDOM_NUMBER_BOUNDARY);
    }
}
