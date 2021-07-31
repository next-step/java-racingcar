package carracing.domain;

import java.util.stream.IntStream;

public class RoundNumber {

    public static final String LESS_THAN_OR_EQUAL_ZERO = "입력값은 0보다 커야합니다 -> ";

    private final int roundNumber;

    public RoundNumber(int roundNumber) {
        validateRoundNumber(roundNumber);
        this.roundNumber = roundNumber;
    }

    public IntStream getRoundIntStream() {
        return IntStream.range(0, roundNumber);
    }

    private void validateRoundNumber(int roundNumber) {
        requireGreaterThanZero(roundNumber);
    }

    private void requireGreaterThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(LESS_THAN_OR_EQUAL_ZERO + number);
        }
    }
}
