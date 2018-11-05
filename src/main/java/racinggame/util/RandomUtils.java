package racinggame.util;

import java.util.Random;

public class RandomUtils {

    public static final Random random = new Random();

    public static final int RANDOM_BOUND_10 = 10;

    public static int getRandom10() {
        return random.nextInt(RANDOM_BOUND_10);
    }
}
