package racingcar.control.input.validator;

public class PositiveValidator implements NumberValidator {
    @Override
    public <T extends Number> void verify(T value) {
        int input = value.intValue();
        if (input <= 0) {
            throw new IllegalArgumentException("input must be positive");
        }
    }
}
