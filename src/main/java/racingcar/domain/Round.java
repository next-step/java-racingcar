package racingcar.domain;

import racingcar.exception.RoundException;

import java.util.Objects;

public class Round {
    private static final int ADD_VALUE = 1;
    private static final int FIRST_ROUND = 0;

    private final int round;

    private Round(int round) {
        validateRound(round);
        this.round = round;
    }

    public static Round init() {
        return new Round(FIRST_ROUND);
    }

    public static Round from(int tryCount) {
        return new Round(tryCount);
    }

    private void validateRound(int round) {
        if (round < FIRST_ROUND) {
            throw new RoundException();
        }
    }

    public Round nextRound() {
        return new Round(round + ADD_VALUE);
    }

    public int currentRound() {
        return round;
    }

    public boolean isOver() {
        return round == FIRST_ROUND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
