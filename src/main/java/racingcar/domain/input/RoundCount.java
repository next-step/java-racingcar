package racingcar.domain.input;

import racingcar.domain.exception.InvalidNumberException;
import racingcar.domain.exception.OnlyPositiveException;

public class RoundCount {

    private int roundCount;

    public RoundCount(String value) {
        this.roundCount = toPositiveNumber(value);
    }

    public RoundCount(int roundCount) {
        validatePositive(roundCount);
        this.roundCount = roundCount;
    }

    public RoundCount(RoundCount round) {
        this.roundCount = round.roundCount;
    }

    private int toPositiveNumber(String value) {
        try {
            return toIntAndValidPositive(value);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }

    private int toIntAndValidPositive(String value) {
        int number = Integer.parseInt(value);
        validatePositive(number);
        return number;
    }

    private void validatePositive(int number) {
        if (number < 1) {
            throw new OnlyPositiveException();
        }
    }

    public int get() {
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
