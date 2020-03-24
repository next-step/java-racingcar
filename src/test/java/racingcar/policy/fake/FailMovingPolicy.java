package racingcar.policy.fake;

import racingcar.policy.MovingPolicy;

public class FailMovingPolicy implements MovingPolicy {
    @Override
    public boolean isPossibleMove() {
        return false;
    }
}
