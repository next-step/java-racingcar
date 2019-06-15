package step2.racing.random;

import java.util.Random;

public class RealRandomGenerator implements RandomGenerator {

    private final Random random = new Random();
    private final int bound;

    public RealRandomGenerator(int bound) {

        this.bound = bound;
    }

    @Override
    public int getRandomIntValue() {

        return random.nextInt(bound);
    }
}
