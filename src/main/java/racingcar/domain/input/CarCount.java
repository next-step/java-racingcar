package racingcar.domain.input;

import racingcar.domain.input.exception.InvalidNumberException;
import racingcar.domain.input.exception.OnlyPositiveException;

public class CarCount {

    private final int carCount;

    public CarCount(String value) {
        this.carCount = toPositiveNumber(value);
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

    public int getCount() {
        return this.carCount;
    }
}
