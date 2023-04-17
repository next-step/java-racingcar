package study.racingcar.strategy;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

    private static final Random random = new Random();
    public static final int RANDOM_BOUND_NUMBER = 10;

    @Override
    public int generate() {
        return random.nextInt(RANDOM_BOUND_NUMBER);
    }
}
