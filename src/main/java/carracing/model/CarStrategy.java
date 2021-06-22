package carracing.model;

import java.util.Random;

public class CarStrategy implements MoveStrategy {
    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_CONDITION = 4;

    public boolean isMovable() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE) >= MOVE_CONDITION;
    }
}
