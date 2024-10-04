package racinggame.domain.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int DEFAULT_BOUND = 10;
    private static final int MINIMUM_MOVE_NUMBER = 4;

    private final Random random = new Random();

    @Override
    public boolean isMoveable() {
        int randomNumber = random.nextInt(DEFAULT_BOUND);
        return randomNumber >= MINIMUM_MOVE_NUMBER;
    }

}
