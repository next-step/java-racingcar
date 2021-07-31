package carracing.view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private static final int INPUT_COUNT_LOWER_LIMIT = 0;
    public static final String INVALID_INPUT_EXCEPTION_MESSAGE_FORMAT = "입력값이 유효하지 않습니다. input: %s";

    private final Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView of(InputStream inputStream) {
        return new InputView(new Scanner(inputStream));
    }

    public int getMoveCount() {
        String inputCount = scanner.nextLine();
        int moveCount = convertStrToInt(inputCount);
        validateLowerLimit(moveCount);
        return moveCount;
    }

    private int convertStrToInt(String inputCount) {
        try {
            return Integer.parseInt(inputCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(INVALID_INPUT_EXCEPTION_MESSAGE_FORMAT, inputCount));
        }
    }

    private void validateLowerLimit(int inputCount) {
        if (inputCount < INPUT_COUNT_LOWER_LIMIT) {
            throw new IllegalArgumentException(String.format(INVALID_INPUT_EXCEPTION_MESSAGE_FORMAT, inputCount));
        }
    }
}
