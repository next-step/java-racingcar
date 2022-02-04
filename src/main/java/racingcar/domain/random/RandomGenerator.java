package racingcar.domain.random;

import java.util.Random;

public class RandomGenerator implements MovementStrategy {

    private static final Random RANDOM_GENERATOR = new Random();
    private static final int LIMIT = 10;

    public int generate() {
        return RANDOM_GENERATOR.nextInt(LIMIT);
    }
}
