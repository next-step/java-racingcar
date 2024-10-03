package race.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();
    private static RandomNumberGenerator randomGenerator;

    private RandomNumberGenerator() {

    }

    public static NumberGenerator getRandomGenerator() {
        if (randomGenerator == null) {
            randomGenerator = new RandomNumberGenerator();
        }
        return randomGenerator;
    }

    @Override
    public int getValue() {
        return random.nextInt(bound);
    }
}
