package racingcar.generator;

import java.util.Random;

public class RandomGenerator {
    public static final Random RANDOM = new Random();
    public static final int RANDOM_MAX_NUMBER = 10;

    public static int generate() {
        return RANDOM.nextInt(RANDOM_MAX_NUMBER);
    }
}
