package racingcar.policy;

import racingcar.policy.CarMovementPolicy;

public class CarImmovablePolicy implements CarMovementPolicy {

    @Override
    public boolean isMovable() {
        return false;
    }
}
