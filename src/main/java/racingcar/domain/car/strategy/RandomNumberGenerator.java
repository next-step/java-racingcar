package racingcar.domain.car.strategy;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final Random RANDOM = new Random();

    private RandomNumberGenerator() {
    }

    public static int generate() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUND);
    }
}
