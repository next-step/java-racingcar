package carracing.logic.type;

import java.util.Objects;

public class Round implements Comparable<Round> {
    private final int value;

    public Round(int value) {
        if (value <= 0) {
            throw new RuntimeException("라운드는 1부터 시작하며, 항상 1 이상입니다");
        }
        this.value = value;
    }

    public int toInt() {
        return value;
    }

    @Override
    public int compareTo(Round other) {
        return Integer.compare(this.toInt(), other.toInt());
    }

    public Round previousRound() {
        if (this.value <= 1) {
            return this;
        }
        return new Round(value - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return value == round.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
