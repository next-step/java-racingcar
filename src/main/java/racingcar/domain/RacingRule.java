package racingcar.domain;

import java.util.Random;

public class RacingRule implements MoveRule {
    private static final int MOVE_CONDITION = 4;
    private static final int RANDOM_NUMBER_RANGE = 9;

    private Random random = new Random();

    @Override
    public boolean checkMovement() {
        int randomNumberRange = RANDOM_NUMBER_RANGE + 1;
        return MOVE_CONDITION <= random.nextInt(randomNumberRange);
    }
}
