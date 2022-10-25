package racingcar.generator;

import java.util.Random;

public class RandomValueGenerator implements Generator {
    public static final int MAXIMUM_UPPER_BOUND = 9;
    public static final Random random = new Random(System.currentTimeMillis());

    public int nextValue() {
        return random.nextInt(MAXIMUM_UPPER_BOUND);
    }
}
