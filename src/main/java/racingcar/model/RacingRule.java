package racingcar.model;

import java.util.Random;

public class RacingRule implements Rule{
    private final int MOVE_CONDITION = 4;
    private Random random = new Random();

    @Override
    public boolean checkRule() {
        return MOVE_CONDITION <= random.nextInt(10);
    }
}
