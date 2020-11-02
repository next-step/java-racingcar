package step03;

import java.util.Random;

public class RandomGenerator {
    private final static Random random = new Random();

    public static int generateZeroToPositiveInt(int to) {
        return random.nextInt(to + 1);
    }
}
