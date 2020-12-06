package racinggame.domain.move;

import java.util.Random;

public class RandomMove implements MoveBehavior{
    private static final int RANDOM_RANGE = 10;
    private static final int MIN_MOVE_RANGE = 4;

    @Override
    public boolean isMove() {
        return new Random().nextInt(RANDOM_RANGE) >= MIN_MOVE_RANGE;
    }
}
