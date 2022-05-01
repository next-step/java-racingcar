package racingcarwinnerrefactor.domain;

import racingcarwinnerrefactor.exception.NumberException;

public class TryCount {

    private final int tryCount;

    public TryCount(int tryCount) {
        assertPositive(tryCount);
        this.tryCount = tryCount;
    }

    public void assertPositive(int tryCount) {
        if(tryCount < 0) throw new NumberException();
    }

    public boolean isBiggerThan(int currentTryCount) {
        return tryCount > currentTryCount;
    }
}
