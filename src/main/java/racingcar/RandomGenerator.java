package racingcar;

import java.util.Random;

public class RandomGenerator {
    private static final int RANDOM_MAX = 10;

    Random random = new Random();

    public int getRandom() {
        return random.nextInt(RANDOM_MAX);
    }
}
