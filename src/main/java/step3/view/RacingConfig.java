package step3.view;

import step3.impl.RandomStrategy;
import step3.model.Count;
import step3.model.TryStrategy;

public class RacingConfig {

    private static final TryStrategy DEFAULT_TRY_STRATEGY = new RandomStrategy();

    private final Count carCount;
    private final Count tryCount;
    private final TryStrategy tryStrategy;

    public RacingConfig(Count carCount, Count tryCount, TryStrategy tryStrategy) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        this.tryStrategy = tryStrategy;
    }

    public RacingConfig(Count carCount, Count tryCount) {
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
