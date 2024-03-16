package step3_racing_car.strategy;

import step3_racing_car.strategy.MovingStrategy;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {
    private static final Random random = new Random();
    private static final int RANDOM_RANGE = 10;
    private static final int MOVING_THRESHOLD = 4;

    @Override
    public int move() {
        int randomNumber = random.nextInt(RANDOM_RANGE);
        if (randomNumber >= MOVING_THRESHOLD) {
            return 1;
        }
        return 0;
    }
}
