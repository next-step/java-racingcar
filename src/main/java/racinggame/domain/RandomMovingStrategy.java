package racinggame.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MAX_POINT_TO_MOVE = 4;
    private static final int MAX_BOUND = 10;

    @Override
    public boolean movable() {
        if (generateRandomNumber() >= MAX_POINT_TO_MOVE) {
            return true;
        }
        return false;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
