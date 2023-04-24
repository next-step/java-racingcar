package racingcar.util;

import java.util.Random;

public final class RandomGenerator {

    private RandomGenerator() {
    }

    public static int generate(int min, int max) {
        Random random = new Random();

        int range = max - min + 1;

        return random.nextInt(range) + min;
    }
}
