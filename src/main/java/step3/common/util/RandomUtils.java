package step3.common.util;

import java.util.Random;

public class RandomUtils {

    private static final int MAXIMUM_NUMBER = 10;
    private static final Random random = new Random();

    public static int generate() {
        return random.nextInt(MAXIMUM_NUMBER);
    }

}
