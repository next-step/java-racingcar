package racingcar.domain;

import java.util.Random;

public class RacingRule implements Rule{
    private static final int MOVE_CONDITION = 4;
    private static final int RANDOM_NUMBER_RANGE = 10;

    private Random random = new Random();

    @Override
    public boolean checkRule() {
        return MOVE_CONDITION <= random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
