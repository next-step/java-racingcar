package domain;

import java.util.Random;

public class GoStraightBehavior implements RacingCarMoveBehavior {
    private static final int MOVING_CONDITION = 4;
    public static final int BOUND = 10;

    @Override
    public boolean isMoving() {
        return getRandomNumber() >= MOVING_CONDITION;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
