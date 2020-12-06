package racingcar;

import java.util.Random;

public class RacingRule implements MoveRule {
    private static final int MOVE_CONDITION = 4;
    private static final int RANDOM_NUMBER_RANGE = 10;

    private Random random = new Random();

    @Override
    public boolean checkMovement() {
        return MOVE_CONDITION <= random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
