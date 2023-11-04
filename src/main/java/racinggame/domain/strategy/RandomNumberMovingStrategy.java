package racinggame.domain.strategy;

import java.util.Random;

public class RandomNumberMovingStrategy implements MovingStrategy {

    public static final int DEFAULT_BOUND = 10;
    private final Random random;

    public RandomNumberMovingStrategy(Random random) {
        this.random = random;
    }

    @Override
    public int nextInt() {
        return random.nextInt(DEFAULT_BOUND);
    }

}
