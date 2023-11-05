package carracing.move_strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPoint {
    public static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static int getPoint() {
        return random.nextInt(10);
    }
}
