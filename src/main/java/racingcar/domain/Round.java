package racingcar.domain;

import racingcar.exception.RoundException;

import java.util.Objects;

public class Round {
    private static final int NEXT_ROUND = 1;
    private static final int FIRST_ROUND = 0;

    private final int finalRound;
    private final int currentRound;

    private Round(int finalRound, int currentRound) {
        validateRound(finalRound, currentRound);
        this.finalRound = finalRound;
        this.currentRound = currentRound;
    }

    public static Round from(int finalRound) {
        return new Round(finalRound, FIRST_ROUND);
    }

    private void validateRound(int finalRound, int currentRound) {
        if (finalRound < currentRound) {
            throw new RoundException();
        }
    }

    public Round nextRound() {
        return new Round(finalRound, currentRound + NEXT_ROUND);
    }

    public int currentRound() {
        return currentRound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return finalRound == round.finalRound && currentRound == round.currentRound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalRound, currentRound);
    }
}
