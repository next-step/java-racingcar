package carracing.util;

import java.security.SecureRandom;

public class RandomUtils {

    public static final Integer DEFAULT_BOUND = 10;

    private static final SecureRandom random = new SecureRandom();

    private RandomUtils() {

    }

    public static Integer nextInt() {
        return random.nextInt(DEFAULT_BOUND);
    }

    public static Integer nextInt(Integer bound) {
        return random.nextInt(bound);
    }

}
