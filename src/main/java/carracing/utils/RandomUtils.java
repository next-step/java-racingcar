package carracing.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static final ThreadLocalRandom random = ThreadLocalRandom.current();
    public static final int THRESHOLD = 10;

    public static int getPoint() {
        return random.nextInt(THRESHOLD);
    }
}
