package racingcar;

import java.util.Random;

class GoStraightBehavior implements RacingCarMoveBehavior {
    private final int MOVING_CONDITION = 4;
    private Random random = new Random();

    @Override
    public int action(int currentDistance) {
        if (isValidCondition(random.nextInt(10))) {
            return currentDistance + 1;
        }
        return currentDistance;
    }

    public boolean isValidCondition(int input) {
        return input >= MOVING_CONDITION;
    }
}
