package racingcar.policy;

import racingcar.policy.CarMovementPolicy;

public class CarMovabilityPolicy implements CarMovementPolicy {

    @Override
    public boolean isMovable() {
        return true;
    }
}
