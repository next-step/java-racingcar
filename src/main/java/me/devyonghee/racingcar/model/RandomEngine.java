package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.Random;

public final class RandomEngine {

    private final Random random;
    private final int limit;

    private RandomEngine(Random random, int limit) {
        Assert.notNull(random, "'random' must not be null");
        validateLimit(limit);
        this.random = random;
        this.limit = limit;
    }

    public static RandomEngine from(Random random, int limit) {
        return new RandomEngine(random, limit);
    }

    int rotationCount() {
        return random.nextInt(limit);
    }

    private void validateLimit(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException(String.format("'limit'(%d) must be positive", limit));
        }
    }

    @Override
    public String toString() {
        return "RandomEngine{" +
                "random=" + random +
                ", limit=" + limit +
                '}';
    }
}
