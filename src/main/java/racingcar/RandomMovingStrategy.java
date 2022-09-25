package racingcar;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    public static final int RANDOM_NUMBER_LIMIT = 10;
    public static final int RANDOM_MOVE_THRESHOLD = 4;

    @Override
    public boolean shouldMove() {
        return generateRandomNumber(RANDOM_NUMBER_LIMIT) >= RANDOM_MOVE_THRESHOLD;
    }

    public int generateRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }
}
