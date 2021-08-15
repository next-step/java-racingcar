package racingcar.domain;

import java.util.Objects;

public class RoundCount {
    private final int roundCount;

    public RoundCount(final int roundCount) {
        validatePositive(roundCount);
        this.roundCount = roundCount;
    }

    private void validatePositive(final int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException("라운드 수는 0보다 커야합니다.");
        }
    }

    public int getValue() {
        return roundCount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RoundCount that = (RoundCount) o;
        return roundCount == that.roundCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundCount);
    }
}
