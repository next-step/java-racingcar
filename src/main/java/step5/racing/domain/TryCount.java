package step5.racing.domain;

import java.util.Objects;

public class TryCount {

    private static final String INVALID_TRY_COUNT_MESSAGE = "시도 회수는 양수여야 합니다.";

    private final int tryCount;

    public TryCount(int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }
    }

    public TryCount decrease() {
        return new TryCount(tryCount - 1);
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
        TryCount other = (TryCount) o;
        return tryCount == other.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }
}
