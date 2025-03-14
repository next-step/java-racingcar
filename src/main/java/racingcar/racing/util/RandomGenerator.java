package racingcar.racing.util;

import java.util.Random;

public class RandomGenerator {
    private final static Random random = new Random();

    public static int generateRandomNumber(int max) {
        return random.nextInt(max);
    }
}
