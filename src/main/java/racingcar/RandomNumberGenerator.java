package racingcar;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random RANDOM = new Random();
    private final int range;

    public RandomNumberGenerator(int range) {
        this.range = range;
    }

    @Override
    public int create() {
        return RANDOM.nextInt(range);
    }
}
