package racing.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;

    public boolean isMoveable() {
        return MOVE_CONDITION <= createRandomValue();
    }

    public static int createRandomValue() {
        return new Random().nextInt(10);
    }
}