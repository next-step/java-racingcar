package model;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final Random random = new Random();

    @Override
    public int nextPosition(int currentPosition) {
        int RANDOM_BOUND = 10;
        int MINIMUM_NUMBER_TO_MOVE = 4;
        if (random.nextInt(RANDOM_BOUND) >= MINIMUM_NUMBER_TO_MOVE) {
            return currentPosition + 1;
        }
        return currentPosition;
    }
}
