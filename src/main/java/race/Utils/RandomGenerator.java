package race.Utils;

import java.util.Random;

public class RandomGenerator implements Generator {
    private final Random random = new Random();
    private static RandomGenerator randomGenerator;

    private RandomGenerator() {

    }

    public static Generator getRandomGenerator() {
        if (randomGenerator == null) {
            randomGenerator = new RandomGenerator();
        }
        return randomGenerator;
    }

    @Override
    public int getValue(int num) {
        return random.nextInt(num);
    }
}
