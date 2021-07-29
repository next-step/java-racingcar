package carracing.view;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final int INPUT_COUNT_LOWER_LIMIT = 0;
    private static final IllegalArgumentException INVALID_INPUT_EXCEPTION = new IllegalArgumentException("입력값이 유효하지 않습니다.");

    private final Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView of(InputStream inputStream) {
        return new InputView(new Scanner(inputStream));
    }

    public int getCount() {
        try {
            int inputCount = scanner.nextInt();
            validateLowerLimit(inputCount);
            return inputCount;
        } catch (InputMismatchException e) {
            throw INVALID_INPUT_EXCEPTION;
        }
    }

    private void validateLowerLimit(int inputCount) {
        if (inputCount < INPUT_COUNT_LOWER_LIMIT) {
            throw INVALID_INPUT_EXCEPTION;
        }
    }
}
