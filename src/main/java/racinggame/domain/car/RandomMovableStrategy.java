package racinggame.domain.car;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {

    private static final int BOUND = 10;
    private static final int MIN_MOVABLE_VALUE = 4;

    private Random random = new Random();

    @Override
    public boolean isMovable() {
        return getMovableRandomValue() >= MIN_MOVABLE_VALUE;
    }

    private int getMovableRandomValue() {
        return random.nextInt(BOUND);
    }
}
