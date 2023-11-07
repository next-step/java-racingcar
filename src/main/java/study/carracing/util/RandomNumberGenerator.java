package study.carracing.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;

    @Override
    public int generatorNumber() {
        return RANDOM.nextInt(BOUND);
    }
}
