package carracing.util;

import java.security.SecureRandom;

public class RandomUtils {

    public static final Integer DEFAULT_BOUND = 10;
    private static final SecureRandom RANDOM = new SecureRandom();

    private RandomUtils() {

    }

    public static Integer nextInt() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }

    public static Integer nextInt(Integer bound) {
        return RANDOM.nextInt(bound);
    }

}
