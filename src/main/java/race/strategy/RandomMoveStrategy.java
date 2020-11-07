package race.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMovable() {
        int RANDOM_RANGE = 10;
        int RANDOM_MOVABLE_MIN_VALUE = 4;

        return new Random().nextInt(RANDOM_RANGE) >= RANDOM_MOVABLE_MIN_VALUE;
    }
}
