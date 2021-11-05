package racingcar;

import java.util.Objects;

public class TryCount {
    private static final int COUNT_ONE = 1;
    private static final int COUNT_ZERO = 0;

    private int tryCount;

    private TryCount(int tryCount) {
        validateCount(tryCount);
        this.tryCount = tryCount;
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
        this.tryCount -= COUNT_ONE;
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
