package study03;

import java.util.Random;

public class Engine {

    private static final int RANDOM_BOUND = 10;
    private static final int ENGINE_RUN_COUNT = 4;
    private final Random random = new Random();

    public boolean isRun() {
        return random.nextInt(RANDOM_BOUND) >= ENGINE_RUN_COUNT;
    }

    // Test Code Only
    public boolean isFixedRun(int fixedValue) {
        return fixedValue >= ENGINE_RUN_COUNT;
    }
}
