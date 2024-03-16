package racing.util;

import java.util.Random;

public class RandomUtil {

    private static final Random RANDOM = new Random();

    public static int randomNumber(int bound) {
        return RANDOM.nextInt(bound);
    }
}
