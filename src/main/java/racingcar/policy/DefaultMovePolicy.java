package racingcar.policy;

import racingcar.domain.RandomNumber;

public class DefaultMovePolicy implements MovePolicy {
    private static final int FORWARD_THRESHOLD = 4;

    @Override
    public boolean canMove(RandomNumber randomNumber) {
        return randomNumber.isGreaterThan(FORWARD_THRESHOLD);
    }
}
