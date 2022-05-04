package racingcar.v2.domain.policy;

import java.util.Random;

public class ZeroToNineRandomMovePolicy implements MovePolicy {

    private static final Random random = new Random();

    private static final int FORWARD_CONDITION = 4;

    @Override
    public boolean apply(int value) {
        return random.nextInt(value) > FORWARD_CONDITION;
    }
}
