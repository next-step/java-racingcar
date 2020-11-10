package racingcar;

import java.util.Random;

class GoStraightBehavior implements RacingCarMoveBehavior {
    private final int MOVING_CONDITION = 4;

    @Override
    public int action(int currentDistance) {
        if (isValidCondition(new Random().nextInt(10))) {
            return currentDistance + 1;
        }
        return currentDistance;
    }

    public boolean isValidCondition(int input) {
        return input >= MOVING_CONDITION;
    }
}
