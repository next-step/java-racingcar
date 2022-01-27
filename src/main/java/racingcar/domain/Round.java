package racingcar.domain;

public class Round {

    private static final String NOT_A_NUMBER_EXCEPTION_MESSAGE = "[ERROR] %s는 숫자가 아닙니다.";
    private static final String ROUND_VALIDATION_MESSAGE = "[ERROR] 횟수는 1 이상이어야 합니다.";
    private static final int MINIMUM_OF_ROUND = 1;

    private int round;

    public Round(String round) {
        int parseRound = toInt(round);
        validateRound(parseRound);
        this.round = parseRound;
    }

    public boolean untilEnd() {
        return --round >= 0;
    }

    public int getRound() {
        return round;
    }

    private int toInt(String round) {
        try {
            return Integer.parseInt(round);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                String.format(NOT_A_NUMBER_EXCEPTION_MESSAGE, round));
        }
    }

    private void validateRound(int round) {
        if (round < MINIMUM_OF_ROUND) {
            throw new IllegalArgumentException(ROUND_VALIDATION_MESSAGE);
        }
    }
}
