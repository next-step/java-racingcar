package step3.manager;

import java.util.Random;

public class RandomManager implements RacingManager {
    private final int TEN = 10;
    private int RUN_CONDITION_VALUE = 4;
    private static final Random random = new Random();

    @Override
    public boolean checkRunCondition() {
        return randomCount() >= RUN_CONDITION_VALUE;
    }

    private int randomCount() {
        return random.nextInt(TEN);
    }
}
