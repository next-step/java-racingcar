package carracing.domain.move;

import java.util.Random;

public class RandomNumberMoveStrategy implements MoveStrategy {

    private static final int ALLOWED_MINIMUM_DISTANCE = 4;
    private static final int RANDOM_NUMBER_BOUND = 10;

    private final Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_NUMBER_BOUND) >= ALLOWED_MINIMUM_DISTANCE;
    }
}
