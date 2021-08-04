package carracing.view;

import carracing.domain.CarName;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final int INPUT_COUNT_LOWER_LIMIT = 0;
    private static final String INVALID_INPUT_EXCEPTION_MESSAGE_FORMAT = "입력값이 유효하지 않습니다. input: %s";
    private static final String CAR_NAMES_INPUT_DELIMITER = ",";

    private final Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView of(InputStream inputStream) {
        return new InputView(new Scanner(inputStream));
    }

    public int getMoveCount() {
        int moveCount = convertStrToInt(scanner.nextLine());
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

    public List<CarName> getCarNames() {
        return parseCarNamesInput().stream()
                .map(CarName::of)
                .collect(Collectors.toList());
    }

    private List<String> parseCarNamesInput() {
        String carNames = scanner.nextLine();
        return Arrays.asList(carNames.split(CAR_NAMES_INPUT_DELIMITER));
    }
}
