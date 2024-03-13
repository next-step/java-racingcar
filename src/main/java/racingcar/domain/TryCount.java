package racingcar.domain;

import java.util.Objects;

public class TryCount {

    private static final String TRY_COUNT_INVALID_MESSAGE = "Try 횟수는 1 이상만 입력이 가능합니다.";
    public static final int MIN_TRY_COUNT = 1;
    public static final int DEFAULT_CURRENT_TRY_COUNT = 0;

    private final int count;

    private final int currentCount;

    public TryCount(int count, int currentCount) {
        validate(count);
        this.count = count;
        this.currentCount = currentCount;
    }

    public TryCount(int count) {
        validate(count);
        this.count = count;
        this.currentCount = DEFAULT_CURRENT_TRY_COUNT;
    }

    private void validate(int count) {
        if (count < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_INVALID_MESSAGE);
        }
    }

    public TryCount getNextTryCount() {
        return new TryCount(this.count, this.currentCount+1);
    }

    public boolean isComplete() {
        return this.count <= this.currentCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TryCount tryCount = (TryCount) o;
        return count == tryCount.count && currentCount == tryCount.currentCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, currentCount);
    }

}
