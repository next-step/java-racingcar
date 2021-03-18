package step4.model;

import java.util.Objects;

public class Round {
    private int round;

    public Round(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("round must be at least 1");
        }
        this.round = round;
    }

    public void race() {
        round--;
    }

    public boolean racing() {
        return round > 0;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Round otherRound = (Round) other;
        return round == otherRound.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
