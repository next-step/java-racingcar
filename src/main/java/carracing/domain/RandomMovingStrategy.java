package carracing.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private final Random random;

    public RandomMovingStrategy() {
        this(new Random());
    }

    public RandomMovingStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean canMove() {
        return random.nextInt(10) >= 4;
    }

}