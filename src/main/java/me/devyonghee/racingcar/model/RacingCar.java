package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

public final class RacingCar {

    private final Name name;
    private final MovementPolicy policy;

    private RacingCar(Name name, MovementPolicy policy) {
        Assert.notNull(name, "'name' must not be null");
        Assert.notNull(policy, "movement policy must not be null");
        this.name = name;
        this.policy = policy;
    }

    static RacingCar from(Name name, MovementPolicy policy) {
        return new RacingCar(name, policy);
    }

    Movement movement() {
        return policy.movement();
    }

    public Name name() {
        return name;
    }
}
