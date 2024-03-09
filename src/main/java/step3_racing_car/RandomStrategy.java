package step3_racing_car;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {
    public static final int RANDOM_RANGE = 10;
    public static final int MOVING_THRESHOLD = 4;

    @Override
    public int getMovingDistance() {
        int randomNumber = new Random().nextInt(RANDOM_RANGE);
        if (randomNumber >= MOVING_THRESHOLD) {
            return 1;
        }
        return 0;
    }
}
