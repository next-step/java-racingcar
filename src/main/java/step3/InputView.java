package step3;

import java.io.Closeable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView implements Closeable {

    private final static InputView INSTANCE = new InputView();
    private final static Scanner SCANNER = new Scanner(System.in);

    private InputView() { }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public Count inputValue() {
        try {
            int input = SCANNER.nextInt();
            lessThanOneException(input);

            return new Count(input);

        } catch(InputMismatchException e) {
            throw new InputMismatchException(MyException.IS_NOT_NUMBER.getMessage());
        }
    }

    private static void lessThanOneException(int input) {
        if(input < 1) {
            throw new IllegalArgumentException(MyException.VALUE_GREATER_THAN_ONE.getMessage());
        }
    }

    @Override
    public void close() {
        SCANNER.close();
    }
}
