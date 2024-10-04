package racingcar;

import java.util.Random;

public class Movement {
    private static final int  MOVE_CONDITION = 4;
    private final Random random;

    public Movement(Random random) {
        this.random = random;
    }

    public boolean isMove() {
        return random.nextInt() >= MOVE_CONDITION;
    }
}
