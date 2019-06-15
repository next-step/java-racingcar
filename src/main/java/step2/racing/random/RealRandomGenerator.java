package step2.racing.random;

import java.util.Random;

public class RealRandomGenerator implements RandomGenerator {

    private final Random random = new Random();

    @Override
    public int getRandomIntValue(int bound) {

        return random.nextInt(bound);
    }
}
