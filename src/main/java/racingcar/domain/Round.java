package racingcar.domain;

import racingcar.exception.ErrorMessage;

public class Round {

    private static final int END_ROUND = 0;
    private static final int ROUND_STEP = 1;

    private int round;

    public static Round of(final int round) {
        return new Round(round);
    }

    Round() {
        this.round = END_ROUND;
    }

    private Round(final int round) {
        validateRound(round);
        this.round = round;
    }

    private void validateRound(final int round) {
        if (round <= END_ROUND) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PARAMETER);
        }
    }

    public Round nextRound() {
        int nextRound = round - ROUND_STEP;
        if (nextRound == END_ROUND) {
            return new Round();
        }
        return Round.of(nextRound);
    }

    public boolean isEndRound() {
        return round <= END_ROUND;
    }
}
