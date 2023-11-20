package racingCar.domain;

import racingCar.domain.validator.TryCountValidator;

public class TryCount {
    public static final int DEFAULT_TRYCOUNT = 0;
    private final int maxCount;
    private int presentCount;

    public TryCount(int maxCount, int presentCount) {
        this.maxCount = maxCount;
        this.presentCount = presentCount;
    }

    public static TryCount from(int maxCount) {
        TryCountValidator.validate(maxCount);
        return new TryCount(maxCount, DEFAULT_TRYCOUNT);
    }

    public boolean isMaxCount() {
        return presentCount == maxCount;
    }

    public void increaseCount() {
        presentCount++;
    }
}
