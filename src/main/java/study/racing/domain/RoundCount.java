package study.racing.domain;

import java.util.Objects;

public class RoundCount {

    private int roundCount;

    public RoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public int value() {
        return this.roundCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoundCount that = (RoundCount) o;
        return roundCount == that.roundCount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(roundCount);
    }
}
