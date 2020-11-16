package domain;

import java.util.Random;

public class GoStraightBehavior implements RacingCarMoveBehavior {
    private static final int MOVING_CONDITION = 4;
    private static final Random RANDOM = new Random();

    @Override
    public int action(int currentDistance) {
        if (isValidCondition(RANDOM.nextInt(10))) {
            return currentDistance + 1;
        }
        return currentDistance;
    }

    public boolean isValidCondition(int input) {
        return input >= MOVING_CONDITION;
    }
}
