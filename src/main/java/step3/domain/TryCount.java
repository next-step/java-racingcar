package step3.domain;

import java.util.Objects;

public class TryCount {

    private int tryCount;

    public TryCount(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        this.tryCount = tryCount;
    }

    public void race() {
        tryCount--;
    }

    public boolean racing() {
        return tryCount > 0;
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
}
