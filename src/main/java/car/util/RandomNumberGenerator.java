package car.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int NUMBER_LIMIT = 10;
    private static final int CAR_STOP = 0;
    private static final int CAR_MOVE = 1;
    private static final int CAR_MOVE_LOWER_LIMIT = 4;

    public int movableAmount() {

        int randomNum = new Random().nextInt(NUMBER_LIMIT);
        if (randomNum >= CAR_MOVE_LOWER_LIMIT) {
            return CAR_MOVE;
        }
        return CAR_STOP;
    }
}
