package step3.view.dto;

import step3.impl.RandomStrategy;
import step3.model.Count;
import step3.model.Names;
import step3.model.TryStrategy;

public class RacingConfigDto {

    private static final TryStrategy DEFAULT_TRY_STRATEGY = new RandomStrategy();

    private final Names names;
    private final Count tryCount;
    private final TryStrategy tryStrategy;

    public RacingConfigDto(String carsName, int tryCount, TryStrategy tryStrategy) {
        this.names = new Names(carsName);
        this.tryCount = new Count(tryCount);
        this.tryStrategy = tryStrategy;
    }

    public RacingConfigDto(String carsName, int tryCount) {
        this(carsName, tryCount, DEFAULT_TRY_STRATEGY);
    }

    public Names getNames() {
        return this.names;
    }

    public Count getTryCount() {
        return this.tryCount;
    }

    public TryStrategy getTryStrategy() {
        return tryStrategy;
    }
}
