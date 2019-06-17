package racingcar.model;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerationStrategy {
    public static final int RANDOM_VALUE_BOUNDARY = 10;

    private Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(RANDOM_VALUE_BOUNDARY);
    }
}
