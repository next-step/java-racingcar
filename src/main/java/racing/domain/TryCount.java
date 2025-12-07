package racing.domain;

import java.util.Objects;

public class TryCount {

    private static final String INVALID_TRY_COUNT_MESSAGE = "시도 횟수는 0 이상이어야 합니다.";
    private static final int MINIMUM_TRY_COUNT = 0;

    private final int tryCount;

    public TryCount(int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new RuntimeException(INVALID_TRY_COUNT_MESSAGE);
        }
    }

    public TryCount decrease() {
        return new TryCount(this.tryCount - 1);
    }

    public boolean isEnd() {
        return this.tryCount == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TryCount count = (TryCount) o;
        return tryCount == count.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }
}
