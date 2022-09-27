package racingcar.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    public static final int RANDOM_NUMBER_LIMIT = 10;
    public static final int RANDOM_MOVE_THRESHOLD = 4;

    public static final Random random = new Random();

    @Override
    public boolean shouldMove() {
        return generateRandomNumber(RANDOM_NUMBER_LIMIT) >= RANDOM_MOVE_THRESHOLD;
    }

    public int generateRandomNumber(int limit) {
        return random.nextInt(limit);
    }
}
