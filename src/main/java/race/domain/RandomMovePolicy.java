package race.domain;

import java.util.Random;

public class RandomMovePolicy implements MovePolicy {

    private static final int MAX_RANDOM_VALUE = 10;
    private static final int RANDOM_CRITICAL_NUMBER = 4;
    private static final int MOVE_STEP_DISTANCE = 1;

    @Override
    public int move() {
        int random = new Random().nextInt(MAX_RANDOM_VALUE);
        if (random >= RANDOM_CRITICAL_NUMBER) {
            return MOVE_STEP_DISTANCE;
        }
        return 0;
    }
}
