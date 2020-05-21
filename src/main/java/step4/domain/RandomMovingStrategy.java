package step4.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{

    private static final int MOVING_POSSIBLE_NUMBER = 4;
    private static final int BOUNDARY = 10;
    private static final Random RANDOM = new Random();

    @Override
    public boolean canMove() {
        return RANDOM.nextInt(BOUNDARY) >= MOVING_POSSIBLE_NUMBER;
    }
}
