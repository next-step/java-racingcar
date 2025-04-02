package racingcar.domain;

import java.util.Objects;

public class RunCount {
    private int count;

    public RunCount(int count) {
        validateNotNegative(count);
        this.count = count;
    }

    private void validateNotNegative(int runCount) {
        if (runCount < 0)
            throw new IllegalArgumentException("runCount should not be negative");
    }

    public boolean isRemaining() {
        return count > 0;
    }

    public void decrease() {
        if (!isRemaining())
            throw new UnsupportedOperationException("runCount is not remaining");

        count--;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RunCount runCount = (RunCount) o;
        return count == runCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
