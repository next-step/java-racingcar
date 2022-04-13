package step3.model;

import step3.impl.RandomStrategy;

public class RacingConfig {

    private static final TryStrategy DEFAULT_TRY_STRATEGY = new RandomStrategy();

    private final Count carCount;
    private final Count tryCount;
    private final TryStrategy tryStrategy;

    public RacingConfig(int carCount, int tryCount, TryStrategy tryStrategy) {
        this.carCount = new Count(carCount);
        this.tryCount = new Count(tryCount);
        this.tryStrategy = tryStrategy;
    }

    public RacingConfig(int carCount, int tryCount) {
        this(carCount, tryCount, DEFAULT_TRY_STRATEGY);
    }

    public int getCarCount() {
        return carCount.getCount();
    }

    public Count getTryCount() {
        return tryCount;
    }

    public TryStrategy getTryStrategy() {
        return tryStrategy;
    }
}
