package racingCar.domain;

import racingCar.domain.validator.TryCountValidator;

public class TryCount {
    private final int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCount from(int tryCount) {
        TryCountValidator.validate(tryCount);
        return new TryCount(tryCount);
    }
}
