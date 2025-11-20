package racinggame.utils;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {
    public static final int MAX_BOUND = 10;

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
