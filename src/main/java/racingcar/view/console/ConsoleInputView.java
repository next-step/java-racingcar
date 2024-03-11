package racingcar.view.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import racingcar.view.InputView;

public class ConsoleInputView implements InputView {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public int readIntNumber() {
        try {
            return scanner.nextInt();
        } catch (final InputMismatchException e) {
            throw new NumberFormatException(INVALID_INT_FORMAT_MESSAGE);
        }
    }
}
