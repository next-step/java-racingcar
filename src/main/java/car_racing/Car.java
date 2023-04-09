package car_racing;

import java.util.Random;

public class Car {
    public static final int INITIAL_COUNT = 0;
    public static final int RANDOM_MAX_BOUND = 9;
    public static final int CAR_MOVE_BOUND = 4;

    int moveCount = INITIAL_COUNT;

    void moveOrStop() {
        Random random = new Random();
        int randomInt = random.nextInt(RANDOM_MAX_BOUND);
        if (randomInt > CAR_MOVE_BOUND) {
            moveCount++;
        }
    }
}
