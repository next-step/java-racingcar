package racingcar.control.input.validator;

import racingcar.validator.Validator;

public class DummyValidator<T> implements Validator<T> {
    @Override
    public void verify(T value) {
        // do nothing
    }
}
