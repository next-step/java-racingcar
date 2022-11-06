package racing.util;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();

    public static int generate(final int min, final int max) {
        return random.nextInt(max) + min;
    }
}
