package car_racing;

import com.google.common.annotations.VisibleForTesting;

import java.util.Random;

public class Car {
    private static final int INITIAL_COUNT = 0;
    private static final int RANDOM_MAX_BOUND = 9;
    private static final int CAR_MOVE_BOUND = 4;

    private int moveCount = INITIAL_COUNT;

    public int getMoveCount() {
        return moveCount;
    }

    void moveOrStop() {
        int randomInt = getRandomInt();
        if (randomInt > CAR_MOVE_BOUND) {
            moveCount++;
        }
    }

    @VisibleForTesting
    public int getRandomInt() {
        Random random = new Random();
        return random.nextInt(RANDOM_MAX_BOUND);
    }
}
