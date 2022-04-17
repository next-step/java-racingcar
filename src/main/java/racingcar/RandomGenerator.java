package racingcar;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private int min;
    private int max;

    public RandomGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int generate() {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
