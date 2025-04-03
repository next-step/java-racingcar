package model;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private final Random rand = new Random();

    @Override
    public boolean isMovable() {
        int movingThreshold = 4;
        int randomNumberUpperBound = 10;
        return rand.nextInt(randomNumberUpperBound) >= movingThreshold;
    }
}
