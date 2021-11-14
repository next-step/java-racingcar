package racingcar.domain;

import racingcar.exception.TryCountException;
import racingcar.exception.TryCountMinusException;

import java.util.Objects;

public class TryCount {
    private static final int COUNT_ONE = 1;
    private static final int COUNT_ZERO = 0;

    private final int finishRound;

    private int tryCount;

    private TryCount(int tryCount) {
        validateCount(tryCount);
        this.tryCount = tryCount;
        this.finishRound = tryCount;
    }

    private void validateCount(int tryCount) {
        if (tryCount < COUNT_ONE) {
            throw new TryCountException(tryCount);
        }
    }

    public static TryCount from(int tryCount) {
        return new TryCount(tryCount);
    }

    public boolean nonOver() {
        return this.tryCount != COUNT_ZERO;
    }

    public void counting() {
        validateMinusCount(COUNT_ONE);
        this.tryCount -= COUNT_ONE;
    }

    private void validateMinusCount(int minusValue) {
        if (this.tryCount - minusValue < COUNT_ZERO) {
            throw new TryCountMinusException(minusValue);
        }
    }

    public int currentRound() {
        return finishRound - tryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryCount tryCount1 = (TryCount) o;
        return tryCount == tryCount1.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }

}
