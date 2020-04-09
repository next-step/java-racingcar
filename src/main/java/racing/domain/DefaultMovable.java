package racing.domain;

import java.util.Random;

public class DefaultMovable implements Movable {
    private static final int RANDOM_VALUE_MAX = 10;
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean isMovable() {
        return new Random().nextInt(RANDOM_VALUE_MAX) >= MOVE_CONDITION;
    }
}
