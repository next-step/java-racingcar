package carracing.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static int getPoint(int threshold) {
        return random.nextInt(threshold);
    }
}
