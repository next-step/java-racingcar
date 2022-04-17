package step3.view.dto;

import step3.impl.RandomStrategy;
import step3.model.Count;
import step3.model.TryStrategy;

public class RacingConfigDto {

    private static final TryStrategy DEFAULT_TRY_STRATEGY = new RandomStrategy();

    private final Count carCount;
    private final Count tryCount;
    private final TryStrategy tryStrategy;

    public RacingConfigDto(int carCount, int tryCount, TryStrategy tryStrategy) {
        this.carCount = new Count(carCount);
        this.tryCount = new Count(tryCount);
        this.tryStrategy = tryStrategy;
    }

    public RacingConfigDto(int carCount, int tryCount) {
        this(carCount, tryCount, DEFAULT_TRY_STRATEGY);
    }

    public Count getCarCount() {
        return this.carCount;
    }

    public Count getTryCount() {
        return this.tryCount;
    }

    public TryStrategy getTryStrategy() {
        return tryStrategy;
    }
}
