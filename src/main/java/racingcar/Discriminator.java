package racingcar;

import java.util.Random;

public class Discriminator {
    private final Random random;

    public Discriminator(Random random) {
        this.random = random;
    }

    public boolean discriminate() {
        return random.nextInt(10) > 3;
    }
}
