package racingcarwinner.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MAX_RANDOM = 9;
    private static final int GO_MIN = 4;
    private static final int GO_MAX = 9;
    private final Random random;

    public RandomMoveStrategy() {
        random = new Random();
    }

    @Override
    public boolean isMovable() {
        int randomNumber = generateRandomNumber();
        return isGoRange(randomNumber);
    }

    private boolean isGoRange(int randomNumber) {
        return randomNumber >= GO_MIN && randomNumber <= GO_MAX;
    }

    private int generateRandomNumber() {
        return random.nextInt(MAX_RANDOM);
    }
}
