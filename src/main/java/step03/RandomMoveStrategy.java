package step03;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_RANGE = 10;
    private static final int MOVABLE_RANGE = 4;
    private static Random random = new Random();

    private static int randomRange() {
        return random.nextInt(RANDOM_RANGE);
    }

    private static boolean isMovable() {
        return randomRange() >= MOVABLE_RANGE;
    }

    @Override
    public boolean move() {
        return isMovable();
    }
}
