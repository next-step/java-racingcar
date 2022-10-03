package domain;

import java.util.Random;

public class MovingStrategy {

    private static final int MOVABLE_CONDITION_NUMBER = 4;
    private static final int RANDOM_NUMBER = 10;
    private static final Random random = new Random();

    public boolean isMovable(int random) {
        return random >= MOVABLE_CONDITION_NUMBER;
    }
    public int getIntValue() {
        return random.nextInt(RANDOM_NUMBER);
    }
}
