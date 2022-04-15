package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

public final class RacingCar {

    private final CarName name;
    private final MovementPolicy policy;

    private RacingCar(CarName name, MovementPolicy policy) {
        Assert.notNull(name, "'name' must not be null");
        Assert.notNull(policy, "movement policy must not be null");
        this.name = name;
        this.policy = policy;
    }

    public static RacingCar from(CarName name, MovementPolicy policy) {
        return new RacingCar(name, policy);
    }

    Movement movement() {
        return policy.movement();
    }

    public CarName name() {
        return name;
    }
}
