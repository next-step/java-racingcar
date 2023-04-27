package racingcar.random;

import java.util.Random;

public final class RandomGenerator {

    private RandomGenerator() {
    }

    public static RandNum generate(int min, int max) {
        Random random = new Random();

        int range = max - min + 1;

        return new RandNum(random.nextInt(range) + min);
    }
}
