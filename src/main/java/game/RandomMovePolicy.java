package game;

import java.util.Random;

public class RandomMovePolicy implements MovePolicy {

    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESH_HOLD = 4;
    private final Random rand = new Random();

    @Override
    public boolean isMovable() {
        int randomNumber = rand.nextInt(RANDOM_BOUND);
        if (randomNumber < MOVE_THRESH_HOLD) {
            return false;
        }
        return true;
    }
}
