package race.domain.car;

import java.util.Random;

public class RandomMoving implements MovingStrategy {
    private static final int MOVE_CONDITION = 4;
    private static final int MAX_VALUE_BOUNDARY = 10;

    private static final Random random = new Random();

    @Override
    public boolean isMove() {
        return random.nextInt(MAX_VALUE_BOUNDARY) >= MOVE_CONDITION;
    }
}
