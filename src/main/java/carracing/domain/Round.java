package carracing.domain;

import java.util.Objects;

public class Round implements Comparable<Round> {
    private static final int FIRST_ROUND_VALUE = 1;
    private final int value;

    public Round(int value) {
        if (value < FIRST_ROUND_VALUE) {
            throw new RuntimeException("라운드는 1부터 시작하므로 항상 1 이상입니다");
        }
        this.value = value;
    }

    public int toInt() {
        return value;
    }

    public Round previousRound() {
        if (isFirstRound()) {
            return this;
        }
        return new Round(value - 1);
    }

    public boolean isFirstRound() {
        return this.value == FIRST_ROUND_VALUE;
    }

    @Override
    public int compareTo(Round other) {
        return Integer.compare(this.toInt(), other.toInt());
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
