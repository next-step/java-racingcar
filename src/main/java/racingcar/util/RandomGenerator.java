package racingcar.util;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();

    public static int randomNumber(int bound) {
        return random.nextInt(bound);
    }
}
