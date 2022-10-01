package racing;

import java.util.Random;

public class RandomRule implements MovingRule{
    private static final int RANDOM_BOUND = 9;
    private static final int TARGET_NUMBER = 4;

    @Override
    public boolean isPossibleToMove() {
        return doesRandomNumberAboveTargetNumber();
    }

    private boolean doesRandomNumberAboveTargetNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND) >= TARGET_NUMBER;
    }
}
