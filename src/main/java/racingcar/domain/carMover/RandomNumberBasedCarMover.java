package racingcar.domain.carMover;

import java.util.Random;

public class RandomNumberBasedCarMover implements NumberBasedCarMover {
    private static final int MAX_NUMBER_THRESHOLD = 10;
    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVING_DISTANCE = 1;

    @Override
    public int move() {
        Random random = new Random();
        if (random.nextInt(MAX_NUMBER_THRESHOLD) >= MOVE_THRESHOLD) {
            return MOVING_DISTANCE;
        }
        return 0;
    }

}
