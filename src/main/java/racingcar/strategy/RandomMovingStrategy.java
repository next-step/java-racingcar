package racingcar.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private final Random random = new Random();
    private final int RANDOM_BOUND = 10;
    private final int AVAILABLE_MOVE_BOUND = 4;

    @Override
    public int move() {
        if (random.nextInt(RANDOM_BOUND) >= AVAILABLE_MOVE_BOUND) {
            return 1;
        }

        return 0;
    }
}
