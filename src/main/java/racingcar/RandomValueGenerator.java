package racingcar;

import java.util.Random;

public class RandomValueGenerator {

    private static final Random random = new Random();

    private RandomValueGenerator() {

    }

    public static int generate() {
        return random.nextInt(10);
    }
}
