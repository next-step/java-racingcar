package step2.racing.random;

import java.util.Random;

public class RealRandomGenerator implements RandomGenerator {

    private final Random random;
    private final int bound;

    public RealRandomGenerator(int bound) {

        this.random = new Random();
        this.bound = bound;
    }

    @Override
    public int getRandomIntValue() {

        return random.nextInt(bound);
    }
}
