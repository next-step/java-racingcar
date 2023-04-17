package racingcar;

import java.util.Random;

public class RandomGenerator {
    private final int min;
    private final int max;

    public RandomGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int generate() {
        Random random = new Random();

        int range = max - min + 1;

        return random.nextInt(range) + min;
    }
}
