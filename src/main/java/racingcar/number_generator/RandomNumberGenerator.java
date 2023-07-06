package racingcar.number_generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final Random RANDOM = new Random();

    public int generate() {
        return RANDOM.nextInt(MAX_VALUE + MIN_VALUE) + MIN_VALUE;
    }
}
