package racingcar;

import java.util.Random;

public class RandomNumberUtil {
    private final static int RANDOM_NUMBER_BOUND = 10;

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
