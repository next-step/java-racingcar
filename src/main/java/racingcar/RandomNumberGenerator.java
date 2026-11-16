package racingcar;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random RANDOM = new Random();
    private final int range;

    public RandomNumberGenerator(int range) {
        this.range = range;
    }

    public int create() {
        return RANDOM.nextInt(range);
    }
}
