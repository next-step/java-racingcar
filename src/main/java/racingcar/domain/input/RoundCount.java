package racingcar.domain.input;

import racingcar.constant.InputExceptionMessage;

public class RoundCount {

    private int roundCount;

    public RoundCount(String value) {
        this.roundCount = toPositiveNumber(value);
    }

    public RoundCount(int roundCount) {
        validatePositive(roundCount);
        this.roundCount = roundCount;
    }

    private int toPositiveNumber(String value) {
        try {
            return toIntAndValidPositive(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(InputExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }

    private int toIntAndValidPositive(String value) {
        int number = Integer.parseInt(value);
        validatePositive(number);
        return number;
    }

    private void validatePositive(int number) {
        if (number < 1) {
            throw new IllegalArgumentException(InputExceptionMessage.ONLY_POSITIVE);
        }
    }

    public int getCount() {
        return this.roundCount;
    }

    public void up() {
        this.roundCount++;
    }

    public boolean isBigger(RoundCount roundCount) {
        return this.roundCount > roundCount.roundCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RoundCount)) {
            return false;
        }
        RoundCount rc = (RoundCount) obj;
        return rc.roundCount == roundCount;
    }
}
