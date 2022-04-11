package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

final class RacingCar {

    private final MovementPolicy policy;

    private RacingCar(MovementPolicy policy) {
        Assert.notNull(policy, "movement policy must not be null");
        this.policy = policy;
    }

    static RacingCar from(MovementPolicy policy) {
        return new RacingCar(policy);
    }

    Movement movement() {
        return policy.movement();
    }
}
