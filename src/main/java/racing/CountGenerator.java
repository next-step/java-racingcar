package racing;

import java.util.Random;

public class CountGenerator {
    private static final int RANDOM_INT_BOUND = 10;
    private static Random random = new Random(System.currentTimeMillis());

    public static int getRandomInt() {
        return random.nextInt(RANDOM_INT_BOUND);
    }
}
