package racing.domain;

import java.util.Objects;

public class TryCount {
    private static final String OVER_COUNT_ERROR_MESSAGE = "시도 횟수를 초과하였습니다.";

    private final int baseTryCount;
    private int tryCount;

    public TryCount(int baseTryCount) {
        this.baseTryCount = baseTryCount;
    }

    public void increaseCount() {
        if (isDone()) {
            throw new IllegalArgumentException(OVER_COUNT_ERROR_MESSAGE + " " + this);
        }
        tryCount++;
    }

    public boolean isDone() {
        return this.baseTryCount == this.tryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryCount tryCount1 = (TryCount) o;
        return baseTryCount == tryCount1.baseTryCount && tryCount == tryCount1.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseTryCount, tryCount);
    }

    @Override
    public String toString() {
        return "TryCount{" +
                "baseTryCount=" + baseTryCount +
                ", tryCount=" + tryCount +
                '}';
    }
}
