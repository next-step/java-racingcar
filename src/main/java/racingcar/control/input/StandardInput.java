package racingcar.control.input;

import racingcar.control.input.validator.DummyValidator;
import racingcar.control.input.validator.Validator;
import racingcar.view.View;

import java.util.Scanner;

public abstract class StandardInput<T> {
    protected static final Scanner scanner = new Scanner(System.in);
    private Validator<T> validator = new DummyValidator<>();

    public StandardInput() {
    }

    public StandardInput(Validator<T> validator) {
        this.validator = validator;
    }

    abstract protected View view();

    abstract protected T input();


    final public T getValue() {
        view().render();

        T result = input();
        validator.verify(result);

        return result;
    }
}
