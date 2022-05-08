package racing_refactoring.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MAX_BOUND = 10;
    private static final int CREATION_VALUE = 4;

    private static final Random random = new Random();

    @Override
    public boolean checkCondition() {
        return random.nextInt(MAX_BOUND) > CREATION_VALUE;
    }
}
