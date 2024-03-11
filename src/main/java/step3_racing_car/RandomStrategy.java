package step3_racing_car;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {
    private static final Random random = new Random();
    public static final int RANDOM_RANGE = 10;
    public static final int MOVING_THRESHOLD = 4;

    @Override
    public int move() {
        int randomNumber = random.nextInt(RANDOM_RANGE);
        if (randomNumber >= MOVING_THRESHOLD) {
            return 1;
        }
        return 0;
    }
}
