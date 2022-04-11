package racingcar.domain.input;

import racingcar.constant.InputExceptionMessage;

public class InputRoundCount {

    private int roundCount;

    public InputRoundCount(String value) {
        this.roundCount = toPositiveNumber(value);
    }

    private int toPositiveNumber(String value) {
        try {
            return toIntAndValidPositive(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(InputExceptionMessage.INVALID_NUMBER_FORMAT);
        } catch (IllegalArgumentException ie) {
            throw new IllegalArgumentException(InputExceptionMessage.ONLY_POSITIVE);
        }
    }

    private int toIntAndValidPositive(String value) {
        int carCount = Integer.parseInt(value);
        validatePositive(carCount);
        return carCount;
    }

    private void validatePositive(int carCount) {
        if (carCount < 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getRoundCount() {
        return this.roundCount;
    }
}
