package racingcar.control.input.validator;

public interface NumberValidator {
    <T extends Number> void verify(T value);
}
