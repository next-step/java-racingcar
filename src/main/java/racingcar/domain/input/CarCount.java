package racingcar.domain.input;

import racingcar.constant.InputExceptionMessage;

public class CarCount {

    private final int carCount;

    public CarCount(String value) {
        this.carCount = toPositiveNumber(value);
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
        int number = Integer.parseInt(value);
        validatePositive(number);
        return number;
    }

    private void validatePositive(int number) {
        if (number < 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getCount() {
        return this.carCount;
    }
}
