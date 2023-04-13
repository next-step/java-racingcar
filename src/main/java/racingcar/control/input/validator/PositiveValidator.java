package racingcar.control.input.validator;

public class PositiveValidator implements Validator<Integer> {
    @Override
    public void verify(Integer value) {
        int input = value;
        if (input <= 0) {
            throw new IllegalArgumentException("input must be positive");
        }
    }
}
