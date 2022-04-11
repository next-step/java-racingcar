package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.Random;

public final class RandomMovementPolicy implements MovementPolicy {

    private static final int MIN_MOVING_ROTATION_LIMIT = 4;
    private static final int RANDOM_LIMIT = 10;

    private final Random random;

    private RandomMovementPolicy(Random random) {
        Assert.notNull(random, "'random' must not be null");
        this.random = random;
    }

    public static RandomMovementPolicy from(Random random) {
        return new RandomMovementPolicy(random);
    }

    @Override
    public Movement movement() {
        if (random() >= MIN_MOVING_ROTATION_LIMIT) {
            return Movement.MOVE;
        }
        return Movement.STOP;
    }

    private int random() {
        return random.nextInt(RANDOM_LIMIT);
    }

    @Override
    public String toString() {
        return "RandomEngine{" +
                "random=" + random +
                '}';
    }
}
