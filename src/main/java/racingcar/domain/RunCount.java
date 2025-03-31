package racingcar.domain;

import java.util.stream.IntStream;

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

    public IntStream intStream() {
        return IntStream.range(0, count);
    }

    public int get() {
        return count;
    }
}
