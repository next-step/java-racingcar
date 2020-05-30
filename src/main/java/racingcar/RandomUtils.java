package racingcar;

import java.util.Random;

public class RandomUtils {
    private static final int RANDOM_NUMBER_BOUNDARY = 10;
    private static final Random RANDOM = new Random();

    public static int generateRandomNum() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUNDARY);
    }
}
