package racingcar.control.input;

import racingcar.view.View;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class InputControl {
    private static final Scanner scanner = new Scanner(System.in);

    abstract protected View view();

    public int receiveInt() {
        this.view().render();
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("input must be integer");
        }
    }
}
