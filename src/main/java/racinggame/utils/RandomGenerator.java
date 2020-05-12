package racinggame.utils;

import java.util.Random;

public class RandomGenerator {

    public static final Random RANDOM = new Random();

    public static int generateUnder(final int limit) {
        return RANDOM.nextInt(limit);
    }
}
