package step3;

import java.io.Closeable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView implements Closeable {

    private static final InputView INSTANCE = new InputView();
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() { }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public Count inputValue() {
        try {
            int input = SCANNER.nextInt();

            return new Count(input);

        } catch(InputMismatchException e) {
            throw new InputMismatchException(MyException.IS_NOT_NUMBER.getMessage());
        }
    }

    @Override
    public void close() {
        SCANNER.close();
    }
}
