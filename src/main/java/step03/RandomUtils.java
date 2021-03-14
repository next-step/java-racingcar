package step03;

import java.util.Random;

public class RandomUtils {

    private static final int RANDOM_RANGE = 10;
    private static Random random = new Random();

    public static int randomRange() {
        return random.nextInt(RANDOM_RANGE);
    }
}
