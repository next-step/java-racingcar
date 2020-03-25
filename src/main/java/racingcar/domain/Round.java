package racingcar.domain;

import java.util.Objects;

public final class Round {
    private static final int END_ROUND = 0;
    private static final int NEXT = 1;

    private int round;

    public Round(final int round) {
        this.round = round;
    }

    public Round next() {
        return new Round(round - NEXT);
    }

    public boolean isEnd() {
        return round == END_ROUND;
    }

    public Round getRound() {
        return new Round(round);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
