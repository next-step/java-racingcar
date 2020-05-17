package game;

import java.util.Random;

public class RandomMovePolicy implements MovePolicy {

    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESH_HOLD = 4;
    private static final int MOVING_RANGE = 1;
    private final Random rand;

    public RandomMovePolicy(Random rand) {
        this.rand = rand;
    }

    @Override
    public int getPosition(int currentPosition) {
        int randomNumber = rand.nextInt(RANDOM_BOUND);
        if (randomNumber < MOVE_THRESH_HOLD) {
            return currentPosition;
        }
        return currentPosition + MOVING_RANGE;
    }
}
