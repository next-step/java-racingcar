package carracing;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private final int MOVING_THRESHOLD = 4;
    private final int RANDOM_NUMBER_BOUNDARY = 10;
    @Override
    public boolean isMovable() {
        Random random = new Random();
        int number = random.nextInt(RANDOM_NUMBER_BOUNDARY);
        return number >= MOVING_THRESHOLD;
    }
}
