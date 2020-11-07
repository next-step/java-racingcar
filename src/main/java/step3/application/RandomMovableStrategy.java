package step3.application;

import step3.domain.MovableStrategy;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final int RANDOM_BOUND = 10;
    private static final int MINIMUM_MOVABLE_VALUE = 4;
    
    @Override
    public boolean isMove() {
        final int randomValue = RANDOM.nextInt(RANDOM_BOUND);
        return randomValue >= MINIMUM_MOVABLE_VALUE;
    }
}
