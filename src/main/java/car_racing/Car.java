package car_racing;

import com.google.common.annotations.VisibleForTesting;

import java.util.Random;

public class Car {
    public static final int INITIAL_COUNT = 0;
    public static final int RANDOM_MAX_BOUND = 9;
    public static final int CAR_MOVE_BOUND = 4;

    int moveCount = INITIAL_COUNT;

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
