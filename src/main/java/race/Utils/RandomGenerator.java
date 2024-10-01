package race.Utils;

import java.util.Random;

public class RandomGenerator implements RandomUtil {
    private final Random random = new Random();
    private static RandomGenerator randomGenerator;

    private RandomGenerator() {

    }

    public static RandomGenerator getRandomGenerator() {
        if (randomGenerator == null) {
            randomGenerator = new RandomGenerator();
        }
        return randomGenerator;
    }

    @Override
    public int getRandomValue(int num) {
        return random.nextInt(num);
    }
}
