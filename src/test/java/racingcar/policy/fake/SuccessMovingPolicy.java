package racingcar.policy.fake;

import racingcar.policy.MovingPolicy;

public class SuccessMovingPolicy implements MovingPolicy {
    @Override
    public boolean isPossibleMove() {
        return true;
    }
}
