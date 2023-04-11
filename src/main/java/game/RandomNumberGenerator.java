package game;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return ThreadLocalRandom
                .current()
                .nextInt(0, 10 + 1);
    }
}