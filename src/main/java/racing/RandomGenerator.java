package racing;

import java.util.Random;

public class RandomGenerator {

    private static final int RANDOM_RANGE = 10;
    private static final Random random = new Random();

    public static int getRandomRange() {
        return random.nextInt(RANDOM_RANGE);
    }
}
