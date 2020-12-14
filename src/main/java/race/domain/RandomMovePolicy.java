package race.domain;

import java.util.Random;

public class RandomMovePolicy implements MovePolicy {

    private static final int MAX_RANDOM_VALUE = 10;
    private static final int MOVE_CRITICAL_NUMBER = 4;
    private static final int MOVE_STEP_DISTANCE = 1;

    private static final Random random = new Random();

    @Override
    public int move() {
        int randomValue = random.nextInt(MAX_RANDOM_VALUE);
        if (randomValue >= MOVE_CRITICAL_NUMBER) {
            return MOVE_STEP_DISTANCE;
        }
        return 0;
    }
}
