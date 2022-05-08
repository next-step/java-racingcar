package racingcar.domain.policy;

import java.util.Random;

public class ZeroToNineRandomMovePolicy implements MovePolicy {

    private static final Random random = new Random();

    private static final int FORWARD_CONDITION = 4;

    private static final int RACING_POLICY_VALUE = 10;

    @Override
    public boolean apply() {
        return random.nextInt(RACING_POLICY_VALUE) > FORWARD_CONDITION;
    }
}
