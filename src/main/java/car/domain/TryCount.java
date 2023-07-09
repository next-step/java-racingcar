package car.domain;

import java.util.Objects;

public final class TryCount {

    private final int tryCount;

    public TryCount(final int count) {
        validateNumber(count);
        this.tryCount = count;
    }

    private void validateNumber(final int num) {
        if (num < 0) {
            throw new IllegalArgumentException("시도 횟수가 음수입니다.");
        }
    }

    public boolean isPositive() {
        return this.tryCount > 0;
    }

    public TryCount decreaseCount() {
        return new TryCount(this.tryCount-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TryCount tryCount1 = (TryCount) o;
        return tryCount == tryCount1.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }

    @Override
    public String toString() {
        return "TryCount{" +
            "tryCount=" + tryCount +
            '}';
    }
}
