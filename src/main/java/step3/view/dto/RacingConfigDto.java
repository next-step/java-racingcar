package step3.view.dto;

import step3.impl.RandomStrategy;
import step3.model.TryStrategy;

public class RacingConfigDto {

    private static final TryStrategy DEFAULT_TRY_STRATEGY = new RandomStrategy();

    private final int carCount;
    private final int tryCount;
    private final TryStrategy tryStrategy;

    public RacingConfigDto(int carCount, int tryCount, TryStrategy tryStrategy) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        this.tryStrategy = tryStrategy;
    }

    public RacingConfigDto(int carCount, int tryCount) {
        this(carCount, tryCount, DEFAULT_TRY_STRATEGY);
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public TryStrategy getTryStrategy() {
        return tryStrategy;
    }
}
