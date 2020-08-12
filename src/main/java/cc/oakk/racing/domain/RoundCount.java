package cc.oakk.racing.domain;

import cc.oakk.racing.util.Validator;

import java.util.Objects;

public class RoundCount {
    int roundCount;
    int currentRoundCount = 0;

    public RoundCount(int roundCount) {
        Validator.checkGreaterThanZero(roundCount);
        this.roundCount = roundCount;
    }

    public void increase() {
        if (!hasNextRound()) {
            throw new IndexOutOfBoundsException("Round has over!");
        }
        currentRoundCount ++;
    }

    public boolean hasNextRound() {
        return roundCount > currentRoundCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundCount that = (RoundCount) o;
        return roundCount == that.roundCount &&
                currentRoundCount == that.currentRoundCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundCount, currentRoundCount);
    }
}
