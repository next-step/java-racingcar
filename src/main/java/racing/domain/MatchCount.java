package racing.domain;

import racing.util.InputValidator;

import java.util.Objects;

public class MatchCount {
    private static final int ZERO = 0;

    private final int count;

    public MatchCount(int count) {
        this.count = InputValidator.validateMatchCount(count);
    }

    public MatchCount decrease() {
        return new MatchCount(this.count - 1);
    }

    public boolean isZero() {
        return this.count == ZERO;
    }

    public MatchCount getMatchCount() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchCount that = (MatchCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return "MatchCount{" +
                "count=" + count +
                '}';
    }
}
