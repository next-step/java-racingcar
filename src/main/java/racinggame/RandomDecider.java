package racinggame;

import java.util.Random;

public class RandomDecider implements MoveDecider {
    public static final int MAX_RANDOM_INTEGER = 10;
    public static final int MIN_MOVE_NUMBER = 4;

    private final Random random = new Random();

    @Override
    public boolean canMove() {
        return getRandomInt() >= MIN_MOVE_NUMBER;
    }

    private int getRandomInt() {
        return random.nextInt(MAX_RANDOM_INTEGER);
    }
}
