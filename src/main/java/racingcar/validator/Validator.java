package racingcar.validator;

public interface Validator<T> {
    void verify(T value);
}
