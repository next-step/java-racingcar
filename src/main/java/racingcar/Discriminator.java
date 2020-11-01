package racingcar;

import java.util.Random;

public class Discriminator {
    private final Random random;
    private static final int THRESHOLD = 4;
    private static final int BOUND = 10;

    public Discriminator(Random random) {
        this.random = random;
    }

    public boolean discriminate() {
        return random.nextInt(BOUND) >= THRESHOLD;
    }
}
