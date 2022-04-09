package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

public final class RacingCar {

    private static final int MIN_MOVING_ROTATION_LIMIT = 4;

    private final RandomEngine engine;

    private RacingCar(RandomEngine engine) {
        Assert.notNull(engine, "'engine' must not be null");
        this.engine = engine;
    }

    public static RacingCar from(RandomEngine engine) {
        return new RacingCar(engine);
    }

    public Movement movement() {
        if (engine.rotationCount() >= MIN_MOVING_ROTATION_LIMIT) {
            return Movement.MOVE;
        }
        return Movement.STOP;
    }
}
