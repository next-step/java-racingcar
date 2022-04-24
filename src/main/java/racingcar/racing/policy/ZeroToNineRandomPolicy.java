package racingcar.racing.policy;

import java.util.Random;

public class ZeroToNineRandomPolicy implements RacingMovePolicy {

    private static final Random random = new Random();

    private static final int FORWARD_CONDITION = 4;

    @Override
    public boolean execute(int value) {
        return random.nextInt(value) > FORWARD_CONDITION;
    }

}
