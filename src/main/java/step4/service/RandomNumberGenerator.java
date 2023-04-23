package step4.service;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements NumberGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    @Override
    public int random(int bound) {
        return RANDOM.nextInt(bound);
    }
}
