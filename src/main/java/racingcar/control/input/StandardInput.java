package racingcar.control.input;

import racingcar.control.input.validator.NumberValidator;
import racingcar.view.View;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public abstract class StandardInput {
    private static final Scanner scanner = new Scanner(System.in);
    private NumberValidator validator;

    public StandardInput() {
    }

    public StandardInput(NumberValidator validator) {
        this.validator = validator;
    }

    abstract protected View view();

    public int getInt() {
        this.view().render();

        int result = input();
        if (Objects.nonNull(validator)) {
            validator.verify(result);
        }
        return result;
    }

    private int input() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("input must be integer");
        }
    }
}
