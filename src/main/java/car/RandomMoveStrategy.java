package car;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final Random random = new Random();
    private static final int DEFAULT_MOVABLE_VALUE = 4;

    @Override
    public boolean movable() {
        return random.nextInt(10) >= DEFAULT_MOVABLE_VALUE;
    }
}
