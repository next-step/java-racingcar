package step3.utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public int generate(int bound) {
        return RANDOM.nextInt(bound);
    }
}
