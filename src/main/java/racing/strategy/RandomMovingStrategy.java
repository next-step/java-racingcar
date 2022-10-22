package racing.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MOVE_LIMIT = 10;
    private static final int MOVE_MIN = 4;

    @Override
    public boolean movable() {
        return randomNumber() >= MOVE_MIN;
    }

    private int randomNumber() {
        Random random = new Random();
        return random.nextInt(MOVE_LIMIT);
    }
}
