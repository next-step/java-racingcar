package racingcar;

import java.util.Random;

public class RandomValueGenerator {

    private static final Random RANDOM = new Random();

    private RandomValueGenerator() {

    }

    public static int generate() {
        return RANDOM.nextInt(10);
    }
}
