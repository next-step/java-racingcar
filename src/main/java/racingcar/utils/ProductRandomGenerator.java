package racingcar.utils;

import java.util.Random;

public class ProductRandomGenerator implements RandomValueGenerator {
    private static final int LIMIT_RANDOM_VALUE = 9;

    @Override
    public int createRandomValue() {
        return new Random().nextInt(LIMIT_RANDOM_VALUE);
    }
}
