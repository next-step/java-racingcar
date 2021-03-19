package step4.model;

import java.util.Objects;

public class RemainingRound {
    private int remainingRound;

    public RemainingRound(int remainingRound) {
        if (remainingRound < 1) {
            throw new IllegalArgumentException("round must be at least 1");
        }
        this.remainingRound = remainingRound;
    }

    public void race() { remainingRound--; }

    public boolean racing() {
        return remainingRound > 0;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        RemainingRound otherRound = (RemainingRound) other;
        return remainingRound == otherRound.remainingRound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(remainingRound);
    }
}
